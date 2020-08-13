package cn.liko.imoocrpc.client;

import cn.liko.imoocrpc.codec.Decoder;
import cn.liko.imoocrpc.codec.Encoder;
import cn.liko.imoocrpc.common.utils.ReflectionUtils;

import java.lang.reflect.Proxy;

/**
 * RpcClient
 *
 * @author liko
 * @date 2020/8/5
 */
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient() {
        this(new RpcClientConfig());
    }

    public RpcClient(RpcClientConfig config) {
        this.config = config;

        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClazz());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClazz());

        this.selector = ReflectionUtils.newInstance(this.config.getSelectorClazz());
        this.selector.init(this.config.getServers(), this.config.getConnectCount(), this.config.getTransportClazz());
    }

    public <T> T getProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{clazz}, new RemoteInvoker(clazz, encoder, decoder, selector));
    }
}
