package cn.likoli.springframework.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * SuperClassTest
 *
 * @author liko
 * @date 2020/8/17
 */
public class SuperClassTest {

    @Test
    public void test() {
        Class<? super HttpSecurity> clazz = HttpSecurity.class;
        while (clazz != null) {
            System.out.println(clazz.getName());
            // Superclass 获取当前类的父类
            clazz = clazz.getSuperclass();
        }
    }
}
