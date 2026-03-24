

import org.junit.jupiter.api.Test;

public class HeartRateMonitor_Test {
        @Test
        public void RecordAHeartRate() {
            Device d = new HeartRateMonitor();
            Observation o = d.sample();

            String text = o.data();}}