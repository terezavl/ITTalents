package main.DPBook.decorator.starbuzz;

public abstract class Beverage {
    public enum Size{
        SMALL(1), MEDIUM(1.5), LARGE(2);
        private double multiplier;
        Size(double multiplier){
            this.multiplier=multiplier;
        }
        public double getMultiplier() {
            return multiplier;
        }
    }

    public Size size;
    public Beverage (Size size){
        this.size=size;
    }

    public abstract String getDescription();

    public abstract double cost();
}
