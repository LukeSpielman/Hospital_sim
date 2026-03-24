import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    void isNormal() {
        Temperature t = new Temperature(40);
        System.out.print(t.critical() + " ");
        System.out.println(t.data());
    }

    @Test
    void isCriticalHighTemp() {
        Temperature t = new Temperature(45);
        System.out.print(t.critical() + " ");
        System.out.println(t.data());
    }
    @Test
    void isCriticalLowTemp() {
        Temperature t = new Temperature(34);
        System.out.print(t.critical() + " ");
        System.out.println(t.data());
    }

}