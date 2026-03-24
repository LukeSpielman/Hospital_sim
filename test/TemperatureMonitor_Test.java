import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureMonitor_Test {

    @Test
    public void RecordATemperature() {
        Device d = new TemperatureMonitor();
        Observation o = d.sample();

        assertNotNull(o);

        String text = o.data();

        assertNotNull(text);
        assertTrue(text.contains("temp"), "Not a temperature: " + text);
        assertTrue(text.contains("C"), "Missing C units: " + text);

}
}