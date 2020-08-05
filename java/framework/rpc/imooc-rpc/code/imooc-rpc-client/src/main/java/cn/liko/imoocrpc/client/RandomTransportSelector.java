package cn.liko.imoocrpc.client;

import cn.liko.imoocrpc.common.utils.ReflectionUtils;
import cn.liko.imoocrpc.proto.Peer;
import cn.liko.imoocrpc.transport.TransportClient;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * RandomTransportSelector
 *
 * @author liko
 * @date 2020/8/5
 */
@Slf4j
public class RandomTransportSelector implements TransportSelector {

    /**
     * 连接好的client
     */
    private List<TransportClient> clients;

    public RandomTransportSelector() {
        this.clients = new ArrayList<>();
    }

    /**
     * 初始化selector
     *
     * @param peers 可以连接的server端点信息
     * @param count client与server建立多少个连接
     * @param clazz client实现class
     */
    @Override
    public synchronized void init(List<Peer> peers, int count, Class<? extends TransportClient> clazz) {
        count = Math.max(count, 1);

        for (Peer peer : peers) {
            for (int i = 0; i < count; i++) {
                TransportClient client = ReflectionUtils.newInstance(clazz);
                client.connect(peer);
                clients.add(client);
            }
            log.info("connect server: {}", peer);
        }
    }

    /**
     * 选择一个transport与server做交互
     *
     * @return
     */
    @Override
    public synchronized TransportClient select() {
        int i = new Random().nextInt(clients.size());
        return clients.remove(i);
    }

    /**
     * 释放用完的client
     *
     * @param client
     */
    @Override
    public synchronized void release(TransportClient client) {
        clients.add(client);
    }

    @Override
    public synchronized void close() {
        clients.forEach(TransportClient::close);
        clients.clear();
    }
}
