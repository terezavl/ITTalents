package main.DPBook.decorator.starbuzz;

public class Mocha extends CondimentDecorator{


    public Mocha(Size size, Beverage beverage) {
        super(size, beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" , Mocha ";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.2*size.getMultiplier();
    }
}
