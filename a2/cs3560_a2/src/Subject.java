import java.util.ArrayList;
import java.util.List;

/**
 * Subject
 */
public class Subject  {
    private List<Observer> observers = new ArrayList<Observer>();

    public void addObserver(Observer observer) {
        observers.add(observer);
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






// // public class Main {
// //     public static void main(String[] args) {
// //         Subject subject = new Subject();
// //         Observer1 observer1 = new Observer1(subject);
// //         Observer2 observer2 = new Observer2(subject);
        
// //         subject.setState(1);
// //         subject.setState(2);
// //     }
// // }

// // // The output of the program is:
// // // Observer1 state: 1
// // // Observer2 state: 1
// // // Observer1 state: 2
// // // Observer2 state: 2

// // // The UML sequence diagram shows the run-time interactions: The Observer1 and Observer2 objects call attach(this) on Subject1 to register themselves. Assuming that the state of Subject1 changes, Subject1 calls notify() on itself. notify() calls update() on the registered Observer1 and Observer2 objects, which request the changed data (getState()) from Subject1 to update (synchronize) their state.


