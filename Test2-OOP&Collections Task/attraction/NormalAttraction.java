package main.attraction;

import main.beasts.Beast;

public class NormalAttraction extends Attraction {

    public NormalAttraction(String name, Beast beast) {
        super(name, beast, AttractionType.NORMAL);
    }

    @Override
    public boolean isBeastValid(Beast beast) {
        return !beast.isDangerous();
    }
}
