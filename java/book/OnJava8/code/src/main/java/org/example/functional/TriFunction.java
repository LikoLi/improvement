package org.example.functional;

import java.util.Objects;
import java.util.function.Function;

/**
 * TriFunction
 *
 * @author liko
 * @date 2020/9/2
 */
@FunctionalInterface
public interface TriFunction<T, U, D, R> {

    R apply(T t, U u, D d);

    default <V> TriFunction<T, U, D, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);

        return (T t, U u, D d) -> after.apply(apply(t, u, d));
    }
}
