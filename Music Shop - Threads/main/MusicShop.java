package main;

import java.util.*;

public class MusicShop {
    private String name;
    private static int MIN=1;
    private Map<MusicInsrument.InstrumentKind,Map< MusicInsrument.InstrumentType, List<MusicInsrument>>>catalog=new HashMap<>();
    private Map<MusicInsrument.InstrumentType,Integer> instrumentsToOrder=new HashMap<>();
    public MusicShop(String name){
        this.name=name;
        this.loadCatalog();
    }

    private void loadCatalog(){
        for (int i = 0; i < MusicInsrument.InstrumentType.values().length; i++) {
            MusicInsrument.InstrumentType type=MusicInsrument.InstrumentType.values()[i];
            MusicInsrument.InstrumentKind kind=MusicInsrument.getKind(type);
            if(!this.catalog.containsKey(kind)) {
                this.catalog.put(kind, new HashMap<>());
            }
            if(!this.catalog.get(kind).containsKey(type)) {
                this.catalog.get(kind).put(type, new ArrayList<>());
            }

        }
        System.out.println("Shop is loaded");
        for (int i = 0; i < 15; i++) {
            MusicInsrument instrument = MusicInsrument.getRandomInstr();
            addInstrument(instrument);
        }
        printCatalog();
    }
    private void addInstrument(MusicInsrument instrument){
        MusicInsrument.InstrumentKind kind=instrument.getKind();
        MusicInsrument.InstrumentType type=instrument.getType();
        if(!this.catalog.containsKey(kind)){
            this.catalog.put(kind,new HashMap<>());
        }
        if(!this.catalog.get(kind).containsKey(type)){
            this.catalog.get(kind).put(type,new ArrayList<>());
        }
        this.catalog.get(kind).get(type).add(instrument);
    }

    public void printCatalog(){
        System.out.println("--------UPDATED AVAILABILITY---------");
        for (MusicInsrument.InstrumentKind kind : catalog.keySet()) {
            System.out.println(kind+" :");
            for (Map.Entry<MusicInsrument.InstrumentType, List<MusicInsrument>> entry : catalog.get(kind).entrySet()) {
                System.out.println("\t"+entry.getKey()+" - "+entry.getValue().size());
            }
        }
    }

    public synchronized void sellInstrument(MusicInsrument.InstrumentType type, int quantity){
        while (!isInstrAvailable(type,quantity)) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("opala");
            }
        }
        MusicInsrument.InstrumentKind kind=MusicInsrument.getKind(type);
        if(this.catalog.containsKey(kind) && this.catalog.get(kind).containsKey(type)) {
            for (int i = 0; i <quantity ; i++) {
                int index=this.catalog.get(kind).get(type).size()-1;
                this.catalog.get(kind).get(type).remove(index);
            }
            System.out.println("Sold "+quantity+" "+type);
        }
        notifyAll();
    }

    private boolean isInstrAvailable(MusicInsrument.InstrumentType type, int quantity){
        MusicInsrument.InstrumentKind kind=MusicInsrument.getKind(type);
        if(this.catalog.containsKey(kind) && this.catalog.get(kind).containsKey(type)) {
            if(this.catalog.get(kind).get(type).size()<quantity){
                System.out.println("Making order for "+quantity+" "+type+" .It will take "+MusicInsrument.getSupplyingTime(type)+"time for delivery");
                if(!this.instrumentsToOrder.containsKey(type)) {
                    this.instrumentsToOrder.put(type, quantity);
                }else {
                    int old=this.instrumentsToOrder.get(type);
                    this.instrumentsToOrder.put(type,old+quantity);
                }
                System.out.println(instrumentsToOrder.size());
                notifyAll();
                return false;
            }
            return true;
        }
        System.out.println("We dont have this instrument!");
        return false;
    }
    public synchronized void deliverInstrument(){
        while (this.getInstrumentsToOrder().size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }

        for(MusicInsrument.InstrumentType type : this.instrumentsToOrder.keySet()){
            try {
                System.out.println("Delivery time for "+type+" is "+MusicInsrument.getSupplyingTime(type));
                Thread.sleep(MusicInsrument.getSupplyingTime(type));
            } catch (InterruptedException e) {
                System.out.println("o no");
            }
            for (int i = 0; i < instrumentsToOrder.get(type); i++) {
                MusicInsrument insrument=new MusicInsrument(type);
                this.addInstrument(insrument);
                System.out.println("Added to shop "+type);
            }
        }
        notifyAll();
        printCatalog();
        this.instrumentsToOrder=new HashMap<>();
    }

    public Map<MusicInsrument.InstrumentType,Integer> getInstrumentsToOrder(){
        for (MusicInsrument.InstrumentKind kind : catalog.keySet()) {
            for(MusicInsrument.InstrumentType type: this.catalog.get(kind).keySet()){
                if(this.catalog.get(kind).get(type).size()<MIN){
                    if(!this.instrumentsToOrder.containsKey(type)) {
                        this.instrumentsToOrder.put(type,MIN);
                    }else{
                        int old = this.instrumentsToOrder.get(type);
                        this.instrumentsToOrder.put(type,old+1);
                    }
                }
            }
        }
        System.out.println("Products to supply: "+instrumentsToOrder);
        return this.instrumentsToOrder;
    }
}

