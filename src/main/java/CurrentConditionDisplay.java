import javax.security.auth.Subject;

public class CurrentConditionDisplay extends WeatherData implements IObserver, IDisplayElement {
    private float temperature;
    private float humidity;
    private ISubject weatherData;


    public CurrentConditionDisplay(ISubject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);

    }

    @Override
    public void updateObserver(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
