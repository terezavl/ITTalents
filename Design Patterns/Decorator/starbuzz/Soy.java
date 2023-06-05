package main.DPBook.decorator.starbuzz;

public class Soy extends CondimentDecorator {

    public Soy(Size size, Beverage beverage) {
        super(size, beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , Soy ";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15* size.getMultiplier();
    }
}
