public class Hospital {
    private Patient[] patients;
    private int count;
    private Queue[] alertQueues;
    private static final int NUM_LEVELS = 5;
    public Hospital(int capacity) {
        patients = new Patient[capacity];
        count = 0;
        alertQueues = new Queue[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++) {
            alertQueues[i] = new Queue();
        }
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
    public int getPatientCount() { return count; }
    public void addAlert(Alert alert) {
        int index = alert.getStars() - 1;
        alertQueues[index].enqueue(alert);
    }
    public Alert getNextAlert() {
        for (int i = NUM_LEVELS - 1; i >= 0; i--) {
            Alert next = alertQueues[i].dequeue();
            if (next != null) {
                return next;
            }
        }
        return null;
    }
    public void printQueueStatus() {
        System.out.println("  [Queue Status]");
        for (int i = NUM_LEVELS - 1; i >= 0; i--) {
            int stars = i + 1;
            Alert front = alertQueues[i].peek();
            String frontInfo = (front == null)
                    ? "empty"
                    : front.getObservation().data()
                    + " (raised at " + front.getTimeRaised() + ")";
            System.out.println("    " + stars + "* : "
                    + alertQueues[i].count()
                    + " waiting | next -> " + frontInfo);
        }
    }
}