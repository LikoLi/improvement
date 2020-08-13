package cn.liko.imoocrpc.example;

import cn.liko.imoocrpc.client.RpcClient;

/**
 * Client
 *
 * @author liko
 * @date 2020/8/5
 */
public class Client {

    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);

        System.out.println(service.add(1, 2));
        System.out.println(service.minus(3, 1));
    }
}
