import java.util.ArrayList;

public class WeatherData implements ISubject {
    private float temperature;
    private float humidity;
    private float pressure;
    private float Max;
    private float Min;
    private float Avg;
    ArrayList <IObserver> observers;
    ArrayList<Float> temp = new ArrayList<>();



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
        observer.updateObserver(temperature,humidity,pressure,Max,Min,Avg);
        }
    }
    public void measurementsChanges(){
        notifyObserver();
    }
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        temp.add(temperature);
        float max = temp.get(0);
        float min = temp.get(0);
        float summ = 0;

        for (int i = 0; i < temp.size(); i++) {
            Max = Math.max(max,temp.get(i));
            Min = Math.min(min,temp.get(i));
            summ = summ + temp.get(i);
        }
        this.Max = Max;
        this.Min = Min;
        this.Avg = summ/temp.size();

        measurementsChanges();
    }
    @Override
    public float getTemperature() {
        return temperature;
    }
    @Override
    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
