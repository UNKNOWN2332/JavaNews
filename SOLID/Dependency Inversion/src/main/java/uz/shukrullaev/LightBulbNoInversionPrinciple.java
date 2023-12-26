package uz.shukrullaev;

/**
 * @author Abdulloh
 * @see uz.shukrullaev
 * @since 12/24/2023 3:47 PM
 */

// Пример без принципа инверсии зависимостей
class LightBulbNoInversionPrinciple {
    void turnOn() {
        // включить лампочку
    }
}

class Switch {
    private final LightBulbNoInversionPrinciple bulb;

    Switch() {
        this.bulb = new LightBulbNoInversionPrinciple();
    }

    void operate() {
        bulb.turnOn();
        System.out.println("Вкл свет");
    }
}
class MainBulb {
    public static void main(String[] args) {
        Switch o = new Switch();
        o.operate();
    }
    /*
     Uzb Qisqacha tarif bu yerda Dependency Inversion Principle
     ishlatilmagan bu yerda qisqa tarif berganda
     pod Classlar super classlarga muhtoj bolib qolish kerakmas super classlarham
     pod classlarga bogliq bolishlari kerakmas ikkalovligi abstractsyaga bogliq bolish kerak
     bu ixchamlig va dynamic boladi.
     */

}
