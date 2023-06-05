package main.DPBook.decorator.starbuzz;

public class HouseBlend extends Beverage{
    public HouseBlend(Size size) {
        super(size);
    }

    @Override
    public String getDescription() {
        return "House Blend "+size;
    }

    @Override
    public double cost() {
        return 0.89* size.getMultiplier();
    }
}
