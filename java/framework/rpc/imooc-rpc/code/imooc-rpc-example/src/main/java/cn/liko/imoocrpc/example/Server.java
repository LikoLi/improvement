package cn.liko.imoocrpc.example;

import cn.liko.imoocrpc.server.RpcServer;
import cn.liko.imoocrpc.server.RpcServerConfig;

/**
 * Server
 *
 * @author liko
 * @date 2020/8/5
 */
public class Server {
    public static void main(String[] args) {
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(CalcService.class, new CalcServiceImpl());
        rpcServer.start();
    }
}
