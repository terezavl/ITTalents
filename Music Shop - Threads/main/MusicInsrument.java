package main;

import java.util.Random;

public class MusicInsrument {
    public enum InstrumentKind{
        STRUNNI, DUHOVI, UDARNI, KLAVISHNI
    }
    public enum InstrumentType{
        KITARA, CIGULKA,
        TROMPET, FLEITA,
        BRABAN, TARAMBUKA,
        PIANO, IONIKA
    }
    private InstrumentKind kind;
    private InstrumentType type;
    private double price;

    public MusicInsrument(InstrumentType type){
        this.type=type;
        this.kind=getKind(type);
    }

    public InstrumentType getType() {
        return type;
    }

    public InstrumentKind getKind() {
        return kind;
    }

    public static InstrumentKind getKind(InstrumentType type) {
        switch (type){
            case KITARA:
            case CIGULKA:
                return InstrumentKind.STRUNNI;
            case TROMPET:
            case FLEITA:
                return InstrumentKind.DUHOVI;
            case BRABAN:
            case TARAMBUKA:
                return InstrumentKind.UDARNI;
            default:
                return InstrumentKind.KLAVISHNI;
        }
    }

    public static MusicInsrument getRandomInstr(){
        int idx= new Random().nextInt(InstrumentType.values().length);
        return new MusicInsrument(InstrumentType.values()[idx]);
    }
    public static MusicInsrument.InstrumentType getRandomInstrType(){
        int idx= new Random().nextInt(InstrumentType.values().length);
        return InstrumentType.values()[idx];
    }

    public static int getSupplyingTime(MusicInsrument.InstrumentType type){
        switch (type){
            case KITARA:
                return 1200;
            case CIGULKA:
                return 1300;
            case TROMPET:
                return 1500;
            case FLEITA:
                return 2000;
            case BRABAN:
                return 3000;
            case TARAMBUKA:
                return 500;
            case PIANO:
                return 4000;
            default:
                return 2800;
        }
    }
}
