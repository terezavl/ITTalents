package main.products;

import java.util.Random;

public class NonAlcohol extends Drink{

    public NonAlcohol(String name) {
        super(name, new Random().nextInt(5)+2, DrinkType.NON_ALCOHOL);
    }
}
