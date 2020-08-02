package cn.liko.imoocrpc.server;

import cn.liko.imoocrpc.codec.Decoder;
import cn.liko.imoocrpc.codec.Encoder;
import cn.liko.imoocrpc.codec.JsonDecoder;
import cn.liko.imoocrpc.codec.JsonEncoder;
import cn.liko.imoocrpc.transport.HttpTransportServer;
import cn.liko.imoocrpc.transport.TransportServer;
import lombok.Data;

/**
 * RpcServerConfig
 *
 * @author liko
 * @date 2020/8/1
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClazz = HttpTransportServer.class;
    private Class<? extends Encoder> encoderClazz = JsonEncoder.class;
    private Class<? extends Decoder> decoderClazz = JsonDecoder.class;
    private int port = 3000;
}
