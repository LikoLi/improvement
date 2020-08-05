package cn.liko.imoocrpc.server;

import cn.liko.imoocrpc.common.utils.ReflectionUtils;
import cn.liko.imoocrpc.proto.Request;

/**
 * ServiceInvoker
 *
 * @author liko
 * @date 2020/8/5
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance service, Request request) {
        return ReflectionUtils.invoke(service.getTarget(), service.getMethod(), request.getParameters());
    }
}
