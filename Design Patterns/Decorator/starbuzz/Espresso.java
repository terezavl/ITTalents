package main.DPBook.decorator.starbuzz;

public class Espresso extends Beverage{
    public Espresso(Size size) {
        super(size);
    }

    @Override
    public String getDescription() {
        return "Espresso "+size;
    }

    @Override
    public double cost() {
        return 1.99* size.getMultiplier();
    }
}
