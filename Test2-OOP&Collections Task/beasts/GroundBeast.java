package main.beasts;

public abstract class GroundBeast extends Beast{

    public GroundBeast(String name, int age, boolean isDangerous) {
        super(name, age, isDangerous, BeastType.GROUND_BEAST);
    }
}
