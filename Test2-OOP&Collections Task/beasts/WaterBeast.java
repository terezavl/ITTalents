package main.beasts;

public abstract class WaterBeast extends Beast{
    private String habitat;
    private int maxDepth;

    public WaterBeast(String name, int age, boolean isDangerous, int maxDepth) {
        super(name, age, isDangerous, BeastType.WATER_BEAST);
        this.maxDepth = maxDepth;
        this.habitat="under water";

    }

    @Override
    public double giveShowPrice() {
        return 75;
    }
}
