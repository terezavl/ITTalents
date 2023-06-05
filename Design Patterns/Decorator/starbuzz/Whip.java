package main.DPBook.decorator.starbuzz;

public class Whip extends CondimentDecorator{

    public Whip(Size size,Beverage beverage) {
        super(size,beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" , Whip ";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.3* size.getMultiplier();
    }
}
