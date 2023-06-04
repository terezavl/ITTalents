package main.DPBook.observer;

public class CurrentConditionDisplay implements DisplayElement, Observer{
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(){
    }

    @Override
    public void display() {
        System.out.println("Current conditions: "+temperature+" degrees C , "+humidity+" % humidity");
    }

    @Override
    public void update(Object data) {
        if(data instanceof WeatherData) {
            this.temperature = ((WeatherData) data).getTemperature();
            this.humidity = ((WeatherData) data).getHumidity();
            display();
        }

    }
}
