package main.products;

import java.util.Random;

public class MainDish extends Meal{

    public MainDish(String name) {
        super(name, 9, new Random().nextInt(401)+400, MealType.MAIN_DISH);
    }
}
