package cn.liko.imoocrpc.client;

import cn.liko.imoocrpc.proto.Peer;
import cn.liko.imoocrpc.transport.TransportClient;

import java.util.List;

/**
 * TransportSelector 服务选择器
 *
 * @author liko
 * @date 2020/8/5
 */
public interface TransportSelector {

    /**
     * 初始化selector
     * @param peers 可以连接的server端点信息
     * @param count client与server建立多少个连接
     * @param clazz client实现class
     */
    void init(List<Peer> peers, int count, Class<? extends TransportClient> clazz);

    /**
     * 选择一个transport与server做交互
     * @return
     */
    TransportClient select();

    /**
     * 释放用完的client
     * @param client
     */
    void release(TransportClient client);

    void close();
}
