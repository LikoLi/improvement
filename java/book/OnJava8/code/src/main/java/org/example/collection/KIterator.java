package org.example.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        System.out.println(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            iterator.remove();
        }

        System.out.println(list);

    }
}
