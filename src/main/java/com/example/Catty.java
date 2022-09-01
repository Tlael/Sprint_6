package com.example;

import java.util.List;

public interface Catty {
    int getKittens();
    List<String> getFood(String animalKind) throws Exception;
}
