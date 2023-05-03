package main.clients;

import main.products.Drink;
import main.products.Meal;
import main.products.Product;
import main.products.ProductSubType;

public class Vegan extends Client{

    public Vegan(String name) {
        super(name, 30);
    }

    @Override
    protected ProductSubType getRandomSubType(Product.ProductType type) {
        switch (type){
            case DRINK:
                return Drink.DrinkType.NON_ALCOHOL;
            default:
                return Meal.MealType.SALAD;
        }
    }
}
