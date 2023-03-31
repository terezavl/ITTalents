package main.beasts;

public abstract class AirBeast extends Beast{
    private boolean canFly=true;
    private int maxFlyingSpeed;
    public AirBeast(String name, int age, boolean isDangerous, int maxFlyingSpeed) {
        super(name, age, isDangerous, BeastType.AIR_BEAST);
        this.maxFlyingSpeed = maxFlyingSpeed;
    }
}
