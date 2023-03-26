import java.util.ArrayList;

public class StatisticDisplay implements IDisplayElement, IObserver {
    private float Max;
    private float Min;
    private float Avg;
    private ISubject weatherData;


    public StatisticDisplay(ISubject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void updateObserver(float temperature, float humidity, float pressure, float Max, float Min, float Avg) {
        this.Max = Max;
        this.Min = Min;
        this.Avg = Avg;

        display();
    }

    @Override
    public void display() {
        System.out.printf(Max + " " + Min + " " + "%.2f",Avg);
        System.out.println();

    }


}
