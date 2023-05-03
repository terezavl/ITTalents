package main.products;

public abstract class Drink extends Product{
    public enum DrinkType implements ProductSubType{ ALCOHOL, NON_ALCOHOL}


    public Drink(String name, int price, DrinkType drinkType) {
        super(name, price, ProductType.DRINK, drinkType);

    }
}
