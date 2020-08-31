package org.example.functional;

import java.util.function.*;

/**
 * FunctionVariants
 *
 * @author liko
 * @date 2020/8/31
 */

class Foo {}

class Bar {
    Foo f;
    Bar(Foo f) {
        this.f = f;
    }
}

class IBaz {
    int i;
    IBaz(int i) {
        this.i = i;
    }
}

class LBaz {
    long l;

    public LBaz(long l) {
        this.l = l;
    }
}

class DBaz {
    double d;

    public DBaz(double d) {
        this.d = d;
    }
}

public class FunctionVariants {
    static Function<Foo, Bar> f1 = f -> new Bar(f);
    static IntFunction<IBaz> f2 = i -> new IBaz(i);
    static LongFunction<LBaz> f3 = l -> new LBaz(l);
    static DoubleFunction<DBaz> f4 = d -> new DBaz(d);
    static ToIntFunction<IBaz> f5 = ib -> ib.i;
    static ToLongFunction<LBaz> f6 = lb -> lb.l;
    static ToDoubleFunction<DBaz> f7 = db -> db.d;
    static IntToLongFunction f8 = i -> i;
    static IntToDoubleFunction f9 = i -> i;
    static LongToIntFunction f10 = i -> (int) i;
    static LongToDoubleFunction f11 = i -> i;
    static DoubleToIntFunction f12 = i -> (int) i;
    static DoubleToLongFunction f13 = d -> (long) d;

    public static void main(String[] args) {
        Bar b = f1.apply(new Foo());
        IBaz ib = f2.apply(11);
        LBaz lb = f3.apply(11L);
        DBaz db = f4.apply(11D);
        int i = f5.applyAsInt(ib);
        long l = f6.applyAsLong(lb);
        double d = f7.applyAsDouble(db);
        long l1 = f8.applyAsLong(1);
        double v = f9.applyAsDouble(1);
        int i1 = f10.applyAsInt(1);
        double v1 = f11.applyAsDouble(1);
        int i2 = f12.applyAsInt(12);
        long l2 = f13.applyAsLong(13);


    }
}
