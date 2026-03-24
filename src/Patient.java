import java.util.UUID;

public class Patient {
    private UUID patientId;
    private Device[] devices;

    public Patient() {
        patientId = UUID.randomUUID();
        devices = new Device[0];
    }

    public UUID getPatientId() {
        return patientId;
    }

    public String toString() {
        return "Patient: " + patientId;
    }

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

    public void Alerts(int time) {
        int i = 0;
        while (i < devices.length) {
            Observation obs = devices[i].sample();

            if (obs.critical()) {
                boolean urgent = true;
                Alert alert = new Alert(obs, time, urgent);


                System.out.println(alert);
            }

            i = i + 1;
        }
    }
}