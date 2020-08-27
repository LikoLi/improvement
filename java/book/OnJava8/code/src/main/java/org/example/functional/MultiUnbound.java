package org.example.functional;

/**
 * MultiUnbound
 *
 * @author liko
 * @date 2020/8/21
 */

class This {
    void two(int i, double d) {}
    void three(int i, double d, String s) {}
    void four(int i, double d, String s, char c) {}
}

interface TwoArgs {
    void call2(This athis, int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(This athis, int i, double d, String s, char c);
}

public class MultiUnbound {
    public static void main(String[] args) {
        TwoArgs two = This::two;
        ThreeArgs three = This::three;
        FourArgs four = This::four;

        This athis = new This();
        two.call2(athis, 11, 3.14);
        three.call3(athis, 11, 3.14, "Thress");
        four.call4(athis, 11, 3.13, "Four", 'Z');
    }
}
