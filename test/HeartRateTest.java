import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeartRateTest {

    @Test
    void isNormal() {
        HeartRate hr = new HeartRate(90);
        System.out.print(hr.critical() + " ");
        System.out.println(hr.data());
    }

    @Test
    void HeartRateHigher() {
        HeartRate hr = new HeartRate(132);
        System.out.print(hr.critical() + " ");
        System.out.println(hr.data());
    }

    @Test
    void HeartRateLower() {
        HeartRate hr = new HeartRate(50);
        System.out.print(hr.critical() + " ");
        System.out.println(hr.data());
    }
}