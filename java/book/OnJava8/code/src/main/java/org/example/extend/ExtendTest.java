package org.example.extend;

/**
 * extend
 *
 * @author liko
 * @date 2020/7/23
 */
public class ExtendTest {


}

class Base {

    public static final String HELLO_WORLD = "Hello World";

    public String say() {
        System.out.println(HELLO_WORLD);
        return HELLO_WORLD;
    }
}

class SayBase extends Base {
    @Override
    public String say() {
        return super.say();
    }
}