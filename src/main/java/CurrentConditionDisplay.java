import javax.security.auth.Subject;

public class CurrentConditionDisplay implements IObserver, IDisplayElement {
    private float temperature;
    private float humidity;
    private ISubject weatherData;


    public CurrentConditionDisplay(ISubject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);

    }

    @Override
    public void updateObserver(float temperature, float humidity, float pressure, float Max, float Min, float Avg) {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }

    @Override
    public void display() {
        System.out.println("current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
