package org.example.functional;

/**
 * CtorReference
 *
 * @author liko
 * @date 2020/8/21
 */

class Dog {
    String name;
    int age = -1;
    Dog() {
        name = "stray";
    }
    Dog(String nm) {
        this.name = nm;
    }
    Dog(String nm, int yrs) {
        name = nm;
        age = yrs;
    }
}

@FunctionalInterface
interface MakeNoArg {
    Dog make();
//    Dog make(String nm);
}

interface Make1Arg {
    Dog make(String nm);
}

interface Make2Args {
    Dog make(String nm, int yrs);
}

public class CtorReference {
    public static void main(String[] args) {
        MakeNoArg mn = Dog::new;
        Make1Arg m1 = Dog::new;
        Make2Args m2 = Dog::new;

        Dog make = mn.make();
        Dog d1 = m1.make("Comet");
        Dog d2 = m2.make("Ralph", 4);


    }
}
