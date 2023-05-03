package main.products;

import java.util.Random;

public class Alcohol extends Drink{

    public Alcohol(String name) {
        super(name, new Random().nextInt(4)+4, DrinkType.ALCOHOL);
    }
}
