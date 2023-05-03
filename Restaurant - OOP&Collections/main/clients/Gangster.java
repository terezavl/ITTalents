package main.clients;

import main.products.Drink;
import main.products.Meal;
import main.products.Product;
import main.products.ProductSubType;

public class Gangster extends Client{

    public Gangster(String name) {
        super(name, 50);
    }

    @Override
    protected ProductSubType getRandomSubType(Product.ProductType type) {
        switch (type){
            case DRINK:
                return Drink.DrinkType.ALCOHOL;
            default:
                return Meal.MealType.MAIN_DISH;
        }
    }
}
