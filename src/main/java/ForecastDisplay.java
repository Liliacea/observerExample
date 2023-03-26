public class ForecastDisplay implements IDisplayElement, IObserver {
    private float currentPressure = 29.2f;
    private float lastPressure;
    private WeatherData weatherData;
    public ForecastDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        if(lastPressure>=currentPressure) {
            System.out.println("Солнечно");
        }else {
            System.out.println("дождь");
        }
    }

    @Override
    public void updateObserver(float temperature, float humidity, float pressure, float Max, float Min, float Avg) {
    lastPressure = currentPressure;
    currentPressure = weatherData.getPressure();
    display();
    }
}
