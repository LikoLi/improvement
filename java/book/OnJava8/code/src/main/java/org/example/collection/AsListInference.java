package org.example.collection;

import java.util.Arrays;

class Snow {}

class Powder extends Snow {}

class Light extends Powder {}

class Heavy extends Powder {}

class Crusty extends Snow {}

class Slush extends Snow {}

public class AsListInference {

    public static void main(String[] args) {
        Arrays.asList(new Crusty(), new Slush(), new Powder(), new Heavy());

        Arrays.<Snow>asList(new Slush());
    }
}
