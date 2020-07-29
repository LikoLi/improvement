package cn.liko.imoocrpc.proto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Peer表示网络传输的一个端点
 *
 * @author liko
 * @date 2020/7/29 11:48 下午
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}
