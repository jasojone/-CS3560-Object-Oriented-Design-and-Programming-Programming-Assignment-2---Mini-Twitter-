import java.util.ArrayList;
import java.util.List;

/**
 * Subject
 */
public abstract class Subject  {
    private List<Observer> observers = new ArrayList<Observer>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    // public void update(String event) {
    //     notifyAllObservers(event);
    // }

}
