package cn.liko.imoocrpc.transport;

/**
 * TransportServer
 *
 *  1. 启动、监听
 *  2. 接收请求
 *  3. 关闭监听
 *
 * @author liko
 * @date 2020/8/1
 */
public interface TransportServer {

    void init(int port, RequestHandler handler);

    void start();

    void stop();
}
