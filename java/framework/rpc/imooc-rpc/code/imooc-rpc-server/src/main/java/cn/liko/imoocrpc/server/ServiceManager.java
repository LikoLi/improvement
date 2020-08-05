package cn.liko.imoocrpc.server;

import cn.liko.imoocrpc.common.utils.ReflectionUtils;
import cn.liko.imoocrpc.proto.Request;
import cn.liko.imoocrpc.proto.ServiceDescriptor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ServiceManager 管理rpc暴露的服务
 *
 * @author liko
 * @date 2020/8/1
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor, ServiceInstance> services;

    public ServiceManager() {
        this.services = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfaceClazz, T bean) {
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClazz);

        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClazz, method);

            services.put(sdp, sis);
            log.info("register service: {} {}", sdp.getClazz(), sdp.getMethod());
        }
    }

    public ServiceInstance lookup(Request request) {
        ServiceDescriptor serviceDescriptor = request.getService();
        return services.get(serviceDescriptor);
    }
}
