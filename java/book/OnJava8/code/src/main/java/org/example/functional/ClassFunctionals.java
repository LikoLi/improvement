package org.example.functional;

import java.util.Comparator;
import java.util.function.*;

/**
 * ClassFunctionals
 *
 * @author liko
 * @date 2020/8/31
 */
class AA {}
class BB {}
class CC {}

/**
 * | **特征**                                  | **函数式方法名**                                             | **示例**                                                     |
 * | ----------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
 * | 无参数； 无返回值                         | **Runnable** (java.lang) `run()`                             | **Runnable**                                                 |
 * | 无参数； 返回类型任意                     | **Supplier** `get()` `getAs类型()`                           | **Supplier`<T>` BooleanSupplier IntSupplier LongSupplier DoubleSupplier** |
 * | 无参数； 返回类型任意                     | **Callable** (java.util.concurrent) `call()`                 | **Callable`<V>`**                                            |
 * | 1 参数； 无返回值                         | **Consumer** `accept()`                                      | **`Consumer<T>` IntConsumer LongConsumer DoubleConsumer**    |
 * | 2 参数 **Consumer**                       | **BiConsumer** `accept()`                                    | **`BiConsumer<T,U>`**                                        |
 * | 2 参数 **Consumer**； 1 引用； 1 基本类型 | **Obj类型Consumer** `accept()`                               | **`ObjIntConsumer<T>` `ObjLongConsumer<T>` `ObjDoubleConsumer<T>`** |
 * | 1 参数； 返回类型不同                     | **Function** `apply()` **To类型** 和 **类型To类型** `applyAs类型()` | **Function`<T,R>` IntFunction`<R>` `LongFunction<R>` DoubleFunction`<R>` ToIntFunction`<T>` `ToLongFunction<T>` `ToDoubleFunction<T>` IntToLongFunction IntToDoubleFunction LongToIntFunction LongToDoubleFunction DoubleToIntFunction DoubleToLongFunction** |
 * | 1 参数； 返回类型相同                     | **UnaryOperator** `apply()`                                  | **`UnaryOperator<T>` IntUnaryOperator LongUnaryOperator DoubleUnaryOperator** |
 * | 2 参数类型相同； 返回类型相同             | **BinaryOperator** `apply()`                                 | **`BinaryOperator<T>` IntBinaryOperator LongBinaryOperator DoubleBinaryOperator** |
 * | 2 参数类型相同; 返回整型                  | Comparator (java.util) `compare()`                           | **`Comparator<T>`**                                          |
 * | 2 参数； 返回布尔型                       | **Predicate** `test()`                                       | **`Predicate<T>` `BiPredicate<T,U>` IntPredicate LongPredicate DoublePredicate** |
 * | 参数基本类型； 返回基本类型               | **类型To类型Function** `applyAs类型()`                       | **IntToLongFunction IntToDoubleFunction LongToIntFunction LongToDoubleFunction DoubleToIntFunction DoubleToLongFunction** |
 * | 2 参数类型不同                            | **Bi操作** (不同方法名)                                      | **`BiFunction<T,U,R>` `BiConsumer<T,U>` `BiPredicate<T,U>` `ToIntBiFunction<T,U>` `ToLongBiFunction<T,U>` `ToDoubleBiFunction<T>`** |
 */

/**
 * 1. 无参数，无返回类型                             -> Runnable
 * 2. 无参数，任意返回类型                            -> Supplier/Callable
 * 3. 有参数，无返回类型
 *  3.1. 1参数，无返回类型                          -> Consumer
 *  3.2. 2参数，无返回类型                          -> BiConsumer
 *  3.3. 2参数(1引用，1基本类型)                     -> ObjIntConsumer<T>/ObjLongConsumer<T>/ObjDoubleConsumer<T>
 * 4. 有参数，有返回类型
 *  4.1. 1参数，返回类型与参数类型不同                -> Function/IntFunction/LongFunction/DoubleFunction/ToIntFunction/ToLongFunction/ToDoubleFunction/IntToLongFunction/IntToDoubleFunction/LongToIntFunction/LongToDoubleFunction/DoubleToIntFunction/DoubleToLongFunction
 *  4.2. 1参数，返回类型与参数类型相同                -> UnaryOperator/IntUnaryOperator/LongUnaryOperator/DoubleUnaryOperator
 *  4.3. 2参数(类型相同), 返回类型与参数类型相同     -> BinaryOperator/IntBinaryOperator/LongBinaryOperator/DoubleBinaryOperator
 *  4.4. 2参数(类型相同), 返回整形                -> Comparator
 *  4.5. 1参数，返回布尔类型                       -> Predicate/IntPredicate/LongPredicate/DoublePredicate
 *  4.6. 2参数，返回布尔类型                     -> BiPredicate
 *  4.7. 1参数(基本类型)，返回基本类型               -> IntToLongFunction/IntToDoubleFunction/LongToIntFunction/LongToDoubleFunction/DoubleToIntFunction/DoubleToLongFunction
 *  4.8. 2参数类型不同(Bi操作)                      -> BiFunction<T, U, R>/BiConsumer<T, U>/BiPredicate<T, U> / ToIntBiFunction<T, U> / ToLongBiFunction<T, U> / ToDoubleBiFunction<T>
 *
 *
 */
public class ClassFunctionals {
    static AA f1() {
        return new AA();
    }

    static int f2(AA aa1, AA aa2) {
        return 1;
    }

    static void f3(AA aa) {}

    static void f4(AA aa, BB bb) {}

    static CC f5(AA aa) {
        return new CC();
    }

    static CC f6(AA aa, BB bb) {
        return new CC();
    }

    static boolean f7(AA aa) {
        return true;
    }

    static boolean f8(AA aa, BB bb) {
        return true;
    }

    static AA f9(AA aa) {
        return new AA();
    }

    static AA f10(AA aa1, AA aa2) {
        return new AA();
    }

    public static void main(String[] args) {
        Supplier<AA> s = ClassFunctionals::f1;
        s.get();

        Comparator<AA> c = ClassFunctionals::f2;
        c.compare(new AA(), new AA());

        Consumer<AA> cons = ClassFunctionals::f3;
        cons.accept(new AA());

        BiConsumer<AA, BB> bicons = ClassFunctionals::f4;
        bicons.accept(new AA(), new BB());

        Function<AA, CC> func = ClassFunctionals::f5;
        CC cc = func.apply(new AA());

        BiFunction<AA, BB, CC> bifunc = ClassFunctionals::f6;
        CC cc1 = bifunc.apply(new AA(), new BB());

        Function<AA, Boolean> bfunc = ClassFunctionals::f7;
        Boolean bool = bfunc.apply(new AA());

        Predicate<AA> predicate = ClassFunctionals::f7;
        boolean test = predicate.test(new AA());

        BiPredicate<AA, BB> biPredicate = ClassFunctionals::f8;
        boolean test1 = biPredicate.test(new AA(), new BB());

        UnaryOperator<AA> uo = ClassFunctionals::f9;
        AA a = uo.apply(new AA());

        BinaryOperator<AA> bo = ClassFunctionals::f10;
        a = bo.apply(new AA(), new AA());


    }


}
