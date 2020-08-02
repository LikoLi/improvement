package cn.liko.imoocrpc.transport;

import cn.liko.imoocrpc.proto.Peer;

import java.io.InputStream;

/**
 * TransportClient
 *  1. 创建连接
 *  2. 发送数据，并且等待响应
 *  3. 关闭连接
 *
 * @author liko
 * @date 2020/8/1
 */
public interface TransportClient {

    void connect(Peer peer);

    InputStream write(InputStream data);

    void close();

}
