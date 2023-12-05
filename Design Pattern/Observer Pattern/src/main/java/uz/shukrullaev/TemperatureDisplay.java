package uz.shukrullaev;

/**
 * @author Abdulloh
 * @see uz.shukrullaev
 * @since 12/5/2023 4:47 PM
 */

// Реализация интерфейса Observer
public class TemperatureDisplay implements Observer,Test2 {
    private int temperature;

    @Override
    public void update(int temperature) {
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.println("Текущая температура: " + temperature + " градусов");
    }
}
