package cn.liko.imoocrpc.server;

import cn.liko.imoocrpc.common.utils.ReflectionUtils;
import cn.liko.imoocrpc.proto.ServiceDescriptor;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ServiceManager 管理rpc暴露的服务
 *
 * @author liko
 * @date 2020/8/1
 */
public class ServiceManager {
    private Map<ServiceDescriptor, ServiceInstance> services;

    public ServiceManager() {
        this.services = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfaceClazz, T bean) {
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClazz);

        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean, method);
        }
    }
}
