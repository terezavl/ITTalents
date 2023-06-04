package main.DPBook.observer;

import java.util.ArrayList;

public class WeatherData implements Subject{
    private float temperature;
    private float humidity;
    private float pressure;
    private ArrayList<Observer> observers=new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Observer was successfully added.");
    }

    @Override
    public void removeObserver(Observer observer) {
        int index=observers.indexOf(observer);
        if(index>=0){
            observers.remove(observer);
            System.out.println("Observer was successfully removed.");
        }
        else {
            System.out.println("The observer is not in the list.");
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
