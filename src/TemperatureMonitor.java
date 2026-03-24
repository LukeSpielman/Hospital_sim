public class TemperatureMonitor extends Device {

    public Observation sample() {
        double c = 36.0 + (Simulation.getRandom().nextDouble() * 4.0);
        return new Temperature(c);
    }
}