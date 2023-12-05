package uz.shukrullaev;

/**
 * @author Abdulloh
 * @see uz.shukrullaev
 * @since 12/5/2023 4:46 PM
 */

// Интерфейс, который реализует объект, за которым можно наблюдать
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

