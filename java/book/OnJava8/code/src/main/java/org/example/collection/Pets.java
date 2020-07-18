package org.example.collection;

import com.sun.tools.javac.util.Assert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pets {

    private static String[] name = new String[]{"Rat", "Manx", "Cymric", "Cymric", "Rat", "EgyptianMau", "Hamster", "EgyptianMau"};

    static Random random = new Random();

    public static List<Pet> list(Integer size) {
        List<Pet> result = new ArrayList<>();
        Assert.checkNonNull(size);
        for (Integer i = 0; i < size; i++) {
            result.add(new Pet(name[i % 8]));
        }
        return result;
    }

    public static Pet get() {
        return new Pet("GET OBJECT");
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Pet {
    private String name;
}
