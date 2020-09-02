package org.example.functional;

/**
 * TriFunctionTest
 *
 * @author liko
 * @date 2020/9/2
 */
public class TriFunctionTest {

    static int f(int i, long l, double d) {
        return 99;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf = TriFunctionTest::f;
        Integer apply = tf.andThen(a -> a * 100).apply(1, 2L, 3.0);
        System.out.println(apply);

        tf = (i, l, d) -> 12;
    }
}
