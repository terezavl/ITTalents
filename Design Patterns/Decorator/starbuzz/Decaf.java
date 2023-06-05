package main.DPBook.decorator.starbuzz;

public class Decaf extends Beverage{
    public Decaf(Size size) {
        super(size);
    }

    @Override
    public String getDescription() {
        return "Decaf "+size;
    }

    @Override
    public double cost() {
        return 1.05* size.getMultiplier();
    }
}
