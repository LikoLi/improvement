package org.example.functional;

import java.util.Arrays;
import java.util.List;

/**
 * LambdaTest
 *
 * @author liko
 * @date 2020/8/25
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3", "4");
        list.forEach(System.out::println);

    }
}
