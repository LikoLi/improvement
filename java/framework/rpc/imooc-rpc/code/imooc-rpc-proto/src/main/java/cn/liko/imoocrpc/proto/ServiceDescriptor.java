package cn.liko.imoocrpc.proto;

import lombok.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * ServiceDescriptor表示服务
 *
 * @author liko
 * @date 2020/7/29 11:52 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDescriptor {
    private String clazz;
    private String method;
    private String returnType;
    private String[] parameterTypes;

    public static ServiceDescriptor from(Class clazz, Method method) {
        ServiceDescriptor serviceDescriptor= new ServiceDescriptor();
        serviceDescriptor.setClazz(clazz.getName());
        serviceDescriptor.setMethod(method.getName());
        serviceDescriptor.setReturnType(method.getReturnType().getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        String[] parameterTypeNames = new String[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            parameterTypeNames[i] = parameterTypes[i].getName();
        }
        serviceDescriptor.setParameterTypes(parameterTypeNames);
        return serviceDescriptor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceDescriptor that = (ServiceDescriptor) o;
        return Objects.equals(clazz, that.clazz) &&
                Objects.equals(method, that.method) &&
                Objects.equals(returnType, that.returnType) &&
                Arrays.equals(parameterTypes, that.parameterTypes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(clazz, method, returnType);
        result = 31 * result + Arrays.hashCode(parameterTypes);
        return result;
    }

    @Override
    public String toString() {
        return "ServiceDescriptor{" +
                "clazz='" + clazz + '\'' +
                ", method='" + method + '\'' +
                ", returnType='" + returnType + '\'' +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                '}';
    }
}
