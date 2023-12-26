package uz.shukrullaev;

/**
 * @author Abdulloh
 * @see uz.shukrullaev
 * @since 12/24/2023 3:56 PM
 */
interface Switchable {
    void turnOn();
}

public class LightBulbWithInversionV2 implements Switchable {

    public void turnOn() {
        System.out.println("Salom man 2 versyaman");
    }

}
class SwitchInversion {
    private Switchable device;

    SwitchInversion(Switchable device) {
        this.device = device;
    }

    void operate() {
        device.turnOn();
    }
}

class MainInversion{
    public static void main(String[] args) {
        SwitchInversion o = new SwitchInversion(new LightBulbWithInversion());
        o.operate();
        SwitchInversion o2 = new SwitchInversion(new LightBulbWithInversionV2());
        o2.operate();
    }
    /*
    * Dependency Inversion bu printsib programmada bo'lib
    * Sub classlar super classlarga bog'liq bo'lishi kerakmas ikkilovi ham
    * abstraktsya bog'liq bo'lishi kerak. yani siz tepadagi misolda korishingiz mumkin abstraktisya orqali
    * 2 ta classlarni bemalol oz ichiga qabul qivoti misol
    * LightBulbWithInversion va LightBulbWithInversionV2 demak bitta abstraktsya bilan
    * bir qancha hil obyektlar kirishi mumkin.*/
}
