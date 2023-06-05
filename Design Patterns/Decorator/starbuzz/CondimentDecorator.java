package main.DPBook.decorator.starbuzz;

public abstract class CondimentDecorator extends Beverage{
    protected Beverage beverage;
    public CondimentDecorator(Size size,Beverage beverage){
        super(size);
        this.beverage=beverage;
    }
}
