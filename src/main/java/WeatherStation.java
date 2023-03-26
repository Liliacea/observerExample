import java.util.ArrayList;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay conditionDisplay = new CurrentConditionDisplay(weatherData);
        StatisticDisplay statisticDisplay = new StatisticDisplay(weatherData);


        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(83,70,29.2f);
    }
}
