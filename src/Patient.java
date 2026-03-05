import java.util.UUID;

public class Patient {
    private UUID patientId;

    public Patient() {
        patientId = UUID.randomUUID();
    }

    public UUID getPatientId() {
        return patientId;
    }

    public String toString() {
        return "Patient: " + patientId;
    }

    public static Patient createPatient() {
        return new Patient();
    }
}