package main.DPBook.observer;

public class ForecastDisplay implements DisplayElement, Observer{
    private String forecast="";
    @Override
    public void display() {
        System.out.println("Forecast: "+forecast);
    }

    @Override
    public void update(Object data) {
        if(data instanceof WeatherData) {
            this.forecast = getWeatherForecast(((WeatherData) data).getTemperature(), ((WeatherData) data).getPressure(),
                    ((WeatherData) data).getHumidity());
            display();
        }
    }

    private String getWeatherForecast(float temperature, float pressure, float humidity) {
        if (temperature > 30 && humidity > 70 && pressure < 1000) {
            return "Hot and humid with low pressure. Chance of thunderstorms.";
        } else if (temperature > 25 && humidity > 60) {
            return "Warm and humid. Possibility of showers.";
        } else if (temperature < 10 && pressure > 1020) {
            return "Cold and high pressure. Expect clear skies.";
        } else {
            return "Weather conditions are normal.";
        }
    }
}
