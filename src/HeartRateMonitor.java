public class HeartRateMonitor extends Device {
    public Observation sample() {
        int bpm = 30 + Simulation.getRandom().nextInt(116);
        HeartRate hr = new HeartRate(bpm);
        return hr;
    }
}