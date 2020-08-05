package cn.liko.imoocrpc.server;

import cn.liko.imoocrpc.codec.Decoder;
import cn.liko.imoocrpc.codec.Encoder;
import cn.liko.imoocrpc.common.utils.ReflectionUtils;
import cn.liko.imoocrpc.proto.Request;
import cn.liko.imoocrpc.proto.Response;
import cn.liko.imoocrpc.proto.ServiceDescriptor;
import cn.liko.imoocrpc.transport.RequestHandler;
import cn.liko.imoocrpc.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

/**
 * RpcServer
 *
 * @author liko
 * @date 2020/8/5
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    public RpcServer(RpcServerConfig config) {
        this.config = config;

        // net
        this.net = ReflectionUtils.newInstance(config.getTransportClazz());
        this.net.init(config.getPort(), this.handler);

        //codec
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClazz());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClazz());

        // service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public <T> void register(Class<T> interfaceClazz, T bean) {
        this.serviceManager.register(interfaceClazz, bean);
    }

    public void start() {
        this.net.start();
    }

    public void stop() {
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream inputStream, OutputStream outputStream) {
            Response response = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(inputStream, inputStream.available());
                Request request = decoder.decode(inBytes, Request.class);
                log.info("Get request: {}", request);

                ServiceInstance sis = serviceManager.lookup(request);
                Object ret = serviceInvoker.invoke(sis, request);
                response.setData(ret);
            } catch (IOException e) {
                log.warn(e.getMessage(), e);
                response.setCode(1);
                response.setMessage("RpcServer got error: " + e.getClass().getName() + "  " + e.getMessage());
            } finally {
                try {
                    IOUtils.write(encoder.encode(response), outputStream);

                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            }
        }
    };
}
