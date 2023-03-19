import java.util.ArrayList;
import java.util.Observer;

public class WeatherData implements ISubject {
    private float temperature;
    private float humidity;
    private float pressure;
    private ArrayList <IObserver> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (IObserver observer : observers) {
        observer.updateObserver(temperature,humidity,pressure);
        }
    }
    public void measurementsChanges(){
        notifyObserver();
    }
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanges();
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
