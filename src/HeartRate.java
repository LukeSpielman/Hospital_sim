public class HeartRate extends Observation {
    private int bpm;
    public HeartRate(int value) {
        bpm = value;
    }
    public boolean critical() {
        return bpm < 40 || bpm > 100;
    }
    public String data() {
        return "heart rate: " + bpm + " bpm";
    }
}