package serviceObserver;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final List<Observer> observers = new ArrayList<>();
    private boolean changed = false;

    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setChanged() {
        this.changed = true;
    }

    public void notifyObservers(Object arg) {
        if (changed) {
            for (Observer observer : observers) {                
                System.out.println("notify");
                observer.update(arg);
            }
            changed = false; // Resetear el estado
        }
    }
}
