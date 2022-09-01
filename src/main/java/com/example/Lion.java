package com.example;

import java.util.List;

public class Lion implements Catty {
    Feline feline;
    boolean hasMane;
    Feline catty;

    public Lion(Feline feline) {
        this.catty = feline;
    }

    public Lion(String sex, Feline feline) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
        this.feline = feline;
    }

    public int getKittens() {
        return catty.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood(String animalKind) throws Exception {
        return catty.getFood("Хищник");
    }
}
