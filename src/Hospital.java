public class Hospital {
    private Patient[] patients;
    private int count;

    public Hospital(int capacity) {
        patients = new Patient[capacity];
        count = 0;
    }

    public void addPatient(Patient pat) {
        if (count < patients.length) {
            patients[count] = pat;
            count++;
        } else {
            System.out.println("Hospital is full.");
        }
    }

    public void printPatients() {
        for (int i = 0; i < count; i++) {
            System.out.println(patients[i]);
        }
    }
}
}
