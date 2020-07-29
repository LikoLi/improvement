package cn.liko.imoocrpc.proto;

import lombok.Data;

/**
 * Response表示RPC的返回
 *
 * @author liko
 * @date 2020/7/29 11:54 下午
 */
@Data
public class Response {
    /**
     * 服务返回编码
     *  0-成功
     *  非零-失败
     */
    private int code = 0;

    /**
     * 具体的错误信息
     */
    private String message = "ok";

    /**
     * 返回的数据
     */
    private Object data;
}
