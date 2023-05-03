package main.products;

import java.util.Random;

public class Salad extends Meal{

    public Salad(String name) {
        super(name, 5, new Random().nextInt(301)+300, MealType.SALAD);
    }
}
