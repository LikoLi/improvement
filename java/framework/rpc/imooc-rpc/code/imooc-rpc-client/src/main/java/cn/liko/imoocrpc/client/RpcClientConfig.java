package cn.liko.imoocrpc.client;

import cn.liko.imoocrpc.codec.Decoder;
import cn.liko.imoocrpc.codec.Encoder;
import cn.liko.imoocrpc.codec.JsonDecoder;
import cn.liko.imoocrpc.codec.JsonEncoder;
import cn.liko.imoocrpc.proto.Peer;
import cn.liko.imoocrpc.transport.HttpTransportClient;
import cn.liko.imoocrpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * RpcClientConfig
 *
 * @author liko
 * @date 2020/8/5
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClazz = HttpTransportClient.class;
    private Class<? extends Encoder> encoderClazz = JsonEncoder.class;
    private Class<? extends Decoder> decoderClazz = JsonDecoder.class;
    private Class<? extends TransportSelector> selectorClazz = RandomTransportSelector.class;

    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1", 3000));
}
