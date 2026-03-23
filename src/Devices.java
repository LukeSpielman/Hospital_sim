public abstract class Device {

    public abstract Observation sample(Patient patient, int time);

    public static class TemperatureMonitor extends Device {

        public Observation sample(Patient patient, int time) {
            double temp = 97.0 + (Simulation.getRandom().nextDouble() * 6.0);
            return new Temperature(patient, time, temp);
        }
    }

    public static class Temperature extends Observation {
        private double degrees;

        public Temperature(Patient patient, int time, double degrees) {
            setPatient(patient);
            setTime(time);
            this.degrees = degrees;
        }

        public double getDegrees() {
            return degrees;
        }

        public String toString() {
            return "Time " + getTime() + " Patient " + getPatient().getPatientId() + " Temperature: " + degrees;
        }
    }

    public static class HeartRateMonitor extends Device {

        public Observation sample(Patient patient, int time) {
            int bpm = 50 + Simulation.getRandom().nextInt(101);
            return new HeartRate(patient, time, bpm);
        }
    }

    public static class HeartRate extends Observation {
        private int bpm;

        public HeartRate(Patient patient, int time, int bpm) {
            setPatient(patient);
            setTime(time);
            this.bpm = bpm;
        }

        public int getBpm() {
            return bpm;
        }

        public String toString() {
            return "Time " + getTime() + " Patient " + getPatient().getPatientId() + " Heart Rate: " + bpm;
        }
    }
}