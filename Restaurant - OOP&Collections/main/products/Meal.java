package main.products;

public abstract class Meal extends Product{

    public enum MealType implements ProductSubType{ SALAD, MAIN_DISH, DESSERT}
    private int quantity;


    public Meal(String name, int price, int quantity, MealType mealType) {
        super(name, price, ProductType.MEAL, mealType);
        this.quantity = quantity;

    }
}
