public class Temperature extends Observation {
    private double celsiusValue;
    public Temperature(double cval) {
        celsiusValue = cval;
    }
    public boolean critical() {
        return celsiusValue < 35.0 || celsiusValue > 39.0;
    }
    public String data() {
        return "temp: " + String.format("%.1f", celsiusValue) + " C";
    }
}