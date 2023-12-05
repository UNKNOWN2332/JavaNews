package uz.shukrullaev;

public class Main {
    public static void main(String[] args) {
        // Создаем субъект (сенсор температуры) и наблюдателя (дисплей)
        TemperatureSensor sensor = new TemperatureSensor();
        TemperatureDisplay display = new TemperatureDisplay();

        // Регистрируем дисплей как наблюдателя
        sensor.registerObserver(display);
        sensor.registerObserver(display);

        // Имитация изменения температуры
        sensor.setTemperature(25);

        sensor.setTemperature(26);
    }
}
/**
 * Observer pattern bu kuzatish bop buning manosini bir tarabdan ozgarish kiritilganda
 * qolganlarga notify kelib qolganlar ham shu habarni oz ichiga oladi bu misol temperaturedan osak boladi
 * Misol: 25 bolsa barcha registratsya qilingan Observerlar graduslari ozgaradi va koribsizgi hammaga notify
 * bolib graduslariham ozgarib qoladi
 * */