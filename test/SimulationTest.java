import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void Sim() {
        Simulation sim = new Simulation();
        sim.setup();
        sim.run();
        sim.process();

    }
}