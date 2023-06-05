package main.DPBook.decorator.starbuzz;

public class DarkRoast extends Beverage{
    public DarkRoast(Size size) {
        super(size);
    }

    @Override
    public String getDescription() {
        return "Dark Roast "+size;
    }

    @Override
    public double cost() {
        return 0.99*size.getMultiplier();
    }
}
