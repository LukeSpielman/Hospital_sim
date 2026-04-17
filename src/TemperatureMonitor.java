public class TemperatureMonitor extends Device {
    public Observation sample() {
        double c = 34.0 + (Simulation.getRandom().nextDouble() * 7.0);
        Temperature t = new Temperature(c);
        return t;
    }
}