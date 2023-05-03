package main.products;

import java.util.Random;

public class Dessert extends Meal{

    public Dessert(String name) {
        super(name,4, new Random().nextInt(101)+200, MealType.DESSERT);
    }
}
