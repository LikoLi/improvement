package org.example.functional;

/**
 * Strategize
 *
 * @author liko
 * @date 2020/8/20
 */

interface Strategy {
    String aproach(String msg);
}

class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}

public class Strategize {

    public static void main(String[] args) {
        Strategy[] strategies = {
                new Strategy() {
                    @Override
                    public String aproach(String msg) {
                        return msg.toUpperCase();
                    }
                },
                msg -> msg.substring(0,  5),
                Unrelated::twice
        };
    }
}
