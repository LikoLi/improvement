package org.example.functional;

import java.util.function.UnaryOperator;

/**
 * FuncationalInterfaceTest
 *
 * @author liko
 * @date 2020/8/31
 */
public class FuncationalInterfaceTest {
}


@FunctionalInterface
interface FunInterface<T> {
    T goodbye(T arg);

    /**
     *
     * @param arg
     * @return
     */
    default T unaryOperator(UnaryOperator<T> arg, T t) {
        return arg.apply(t);
    }

    @Override
    boolean equals(Object obj);
}
