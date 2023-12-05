package uz.shukrullaev;

/**
 * @author Abdulloh
 * @see uz.shukrullaev
 * @since 12/5/2023 4:47 PM
 */

import java.util.ArrayList;
import java.util.List;

// Реализация интерфейса Subject
public class TemperatureSensor implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

