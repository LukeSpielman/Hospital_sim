public class HeartRateMonitor extends Device {

    public Observation sample() {
        int bpm = 55 + (Simulation.getRandom().nextInt(91));
        return new HeartRate(bpm);
    }
}