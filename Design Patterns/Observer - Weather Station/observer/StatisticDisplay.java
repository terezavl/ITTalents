package main.DPBook.observer;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StatisticDisplay implements DisplayElement, Observer{
    private ArrayList<Float> temperatureList;
    private ArrayList<Float> humidityList;
    private ArrayList<Float> pressureList;

    public StatisticDisplay(){
        this.humidityList=new ArrayList<>();
        this.temperatureList=new ArrayList<>();
        this.pressureList=new ArrayList<>();
    }

    @Override
    public void display() {
        float avTemp= (this.temperatureList.stream().reduce(0.0f, (num,total) -> num + total))/ temperatureList.size();
        float maxTemp=this.temperatureList.stream().max((o1, o2) -> Float.compare(o1,o2)).get();
        float minTemp=this.temperatureList.stream().min((o1, o2) -> Float.compare(o1,o2)).get();

        float avHumidity= (this.humidityList.stream().reduce(0.0f, (num,total) -> num + total))/ humidityList.size();
        float maxHumidity=this.humidityList.stream().max((o1, o2) -> Float.compare(o1,o2)).get();
        float minHumidity=this.humidityList.stream().min((o1, o2) -> Float.compare(o1,o2)).get();

        float avPressure= (this.pressureList.stream().reduce(0.0f, (num,total) -> num + total))/ pressureList.size();
        float maxPressure=this.pressureList.stream().max((o1, o2) -> Float.compare(o1,o2)).get();
        float minPressure=this.pressureList.stream().min((o1, o2) -> Float.compare(o1,o2)).get();

        System.out.println("Avg/Min/Max temperature: "+avTemp+"/"+minTemp+"/"+maxTemp);
        System.out.println("Avg/Min/Max humidity: "+avHumidity+"/"+minHumidity+"/"+maxHumidity);
        System.out.println("Avg/Min/Max pressure: "+avPressure+"/"+minPressure+"/"+maxPressure);
    }

    @Override
    public void update(Object data) {
        if(data instanceof WeatherData){
            this.temperatureList.add(((WeatherData) data).getTemperature());
            this.humidityList.add(((WeatherData) data).getHumidity());
            this.pressureList.add(((WeatherData) data).getPressure());
            display();
        }
    }
}
