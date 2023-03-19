import java.util.Observer;

public interface ISubject {


    void registerObserver(IObserver o);

    void removeObserver(IObserver o);
    void notifyObserver();


}
