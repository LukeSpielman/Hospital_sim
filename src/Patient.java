import java.util.UUID;
public class Patient {
    private UUID patientId;
    private Device[] devices;
    public Patient() {
        patientId = UUID.randomUUID();
        devices = new Device[0];
    }
    public UUID getPatientId() { return patientId; }
    public String toString() { return "Patient: " + patientId; }
    public static Patient createPatient() {
        Patient patient = new Patient();
        patient.setDevices(new Device[] {
                new TemperatureMonitor(),
                new HeartRateMonitor()
        });
        return patient;
    }
    public void setDevices(Device[] newDevices) {
        devices = newDevices;
    }
    public void generateAlerts(int time, Hospital hospital) {
        int i = 0;
        while (i < devices.length) {
            Observation obs = devices[i].sample();
            if (obs.critical()) {
                StarRating rating = StarRating.random();
                Alert alert = new Alert(obs, time, rating);
                hospital.addAlert(alert);
                System.out.println("  Time " + time
                        + ": Alert generated " + rating
                        + " -> " + obs.data());
            }
            i = i + 1;
        }
    }
}