package cn.liko.imoocrpc.common.utils;

import junit.framework.TestCase;

import java.lang.reflect.Method;

public class ReflectionUtilsTest extends TestCase {

    public void testNewInstance() {
        TestClass testClass = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(testClass);
    }

    public void testGetPublicMethods() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        assertEquals(1, methods.length);

        String name = methods[0].getName();
        assertEquals("b", name);
    }

    public void testInvoke() {
        TestClass testClass = ReflectionUtils.newInstance(TestClass.class);
        Method[] methods = ReflectionUtils.getPublicMethods(testClass.getClass());

        Object invoke = ReflectionUtils.invoke(testClass, methods[0]);

        assertEquals("b", invoke);
    }
}