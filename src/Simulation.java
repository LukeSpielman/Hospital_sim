import java.util.Random;
public class Simulation {
    private static Random rand = new Random();
    public static Random getRandom() {
        return rand;

    }
    private int totalTime  = 600;
    private int currentTime = 0;
    private double admissionRate           = 0.66;
    private double nurseBaseProb           = 0.30;
    private double telemedicineProb        = 0.40;
    private int    numNurses               = 3;
    private int    maxTelemedicineSessions = 1;
    private int telemedicineSlots = 0;
    private Hospital hospital;
    private Nurse[]  nurses;
    private Queue    completedAlerts;
    public Simulation() {}
    public void setup() {
        hospital          = new Hospital(50);
        completedAlerts   = new Queue();
        telemedicineSlots = 0;
        currentTime       = 0;
        nurses = new Nurse[numNurses];
        for (int i = 0; i < numNurses; i++) {
            nurses[i] = new Nurse("Nurse-" + (char)('A' + i),
                    nurseBaseProb, telemedicineProb);
        }
        System.out.println("=== Simulation Setup ===");
        System.out.println("Nurses             : " + numNurses);
        System.out.println("Telemedicine slots : " + maxTelemedicineSessions);
        System.out.println("Nurse base prob    : " + nurseBaseProb);
        System.out.println("Telemedicine prob  : " + telemedicineProb);
        System.out.println("========================");
    }
    public void run() {
        while (currentTime <= totalTime) {
            processStep();
            currentTime += 10;
        }
    }
    private void processStep() {
        System.out.println("\nTime " + currentTime + ":");
        if (rand.nextInt(100) < 66) {
            Patient p = Patient.createPatient();
            hospital.addPatient(p);
            System.out.println("  New patient admitted. Total: "
                    + hospital.getPatientCount());
            p.generateAlerts(currentTime, hospital);
        }
        hospital.printQueueStatus();
        System.out.println("  Completed alerts so far: " + completedAlerts.count());
        for (Nurse nurse : nurses) {
            telemedicineSlots = nurse.resolve(hospital, currentTime,
                    completedAlerts,
                    telemedicineSlots,
                    maxTelemedicineSessions);
        }
    }
    public void process() {
        System.out.println("\n========== SIMULATION RESULTS ==========");
        System.out.println("Nurses             : " + numNurses);
        System.out.println("Telemedicine slots : " + maxTelemedicineSessions);
        System.out.println("Total patients     : " + hospital.getPatientCount());
        int[] countPerStar = new int[5 + 1];
        int[] sumPerStar   = new int[5 + 1];
        int[] maxPerStar   = new int[5 + 1];
        int totalResolved     = 0;
        int sumResolutionTime = 0;
        int maxResolutionTime = 0;
        Alert a = completedAlerts.dequeue();
        while (a != null) {
            totalResolved++;
            int rt    = a.resolutionTime();
            int stars = a.getStars();
            sumResolutionTime += rt;
            if (rt > maxResolutionTime) maxResolutionTime = rt;
            countPerStar[stars]++;
            sumPerStar[stars] += rt;
            if (rt > maxPerStar[stars]) maxPerStar[stars] = rt;
            a = completedAlerts.dequeue();
        }
        System.out.println("Total alerts resolved: " + totalResolved);
        if (totalResolved > 0) {
            double mean = (double) sumResolutionTime / totalResolved;
            System.out.printf("Mean resolution time : %.1f minutes%n", mean);
            System.out.println("Max  resolution time : " + maxResolutionTime + " minutes");
            System.out.println("\n--- Breakdown by Star Rating (5* to 1*) ---");
            for (int s = 5; s >= 1; s--) {
                if (countPerStar[s] > 0) {
                    double starMean = (double) sumPerStar[s] / countPerStar[s];
                    System.out.printf("  %d* : %d resolved | mean=%.1f mins | max=%d mins%n",
                            s, countPerStar[s], starMean, maxPerStar[s]);
                } else {
                    System.out.printf("  %d* : 0 resolved%n", s);
                }
            }
        } else {
            System.out.println("No alerts were resolved during this simulation.");
        }
        System.out.println("=========================================");
        hospital.printPatients();
    }
}