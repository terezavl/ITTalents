package main.clients;

import main.products.Drink;
import main.products.Meal;
import main.products.Product;
import main.products.ProductSubType;

import java.util.Random;

public class Student extends Client{

    public Student(String name) {
        super(name, 10);
    }

    @Override
    protected ProductSubType getRandomSubType(Product.ProductType type) {
        switch (type){
            case DRINK:
                if(new Random().nextBoolean()){
                    return Drink.DrinkType.NON_ALCOHOL;
                }
                return Drink.DrinkType.ALCOHOL;
            default:
                int chance=new Random().nextInt(3);
                if(chance==0){
                    return Meal.MealType.SALAD;
                }
                if(chance==1){
                    return Meal.MealType.DESSERT;
                }
                return Meal.MealType.MAIN_DISH;
        }
    }
}
