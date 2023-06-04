package main.DPBook.observer;

import java.beans.PropertyChangeListener;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData=new WeatherData();
        CurrentConditionDisplay currentConditionDisplay=new CurrentConditionDisplay();
        StatisticDisplay statisticDisplay = new StatisticDisplay();
        ForecastDisplay forecastDisplay=new ForecastDisplay();

        weatherData.registerObserver(currentConditionDisplay);
        weatherData.registerObserver(statisticDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(8,60,1030f);
        weatherData.setMeasurements(20,70,1050f);
        weatherData.setMeasurements(32,68,900f);

    }
}
