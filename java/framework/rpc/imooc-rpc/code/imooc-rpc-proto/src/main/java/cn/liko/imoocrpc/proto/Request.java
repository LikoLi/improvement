package cn.liko.imoocrpc.proto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request表示RPC的一个请求
 *
 * @author liko
 * @date 2020/7/29 11:53 下午
 */
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;
}
