class HeartRate extends Observation {
    private int bpm;

    public HeartRate(int value) {
        bpm = value;
    }

    public boolean critical() {
        return bpm < 62 || bpm > 122;
    }

    public String data() {
        return "heart rate: " + bpm + " bpm";
    }
}