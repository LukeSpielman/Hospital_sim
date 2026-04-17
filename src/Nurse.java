public class Nurse {
    private String name;
    private Alert  currentAlert;
    private double resolveProb;
    private double telemedicineProb;
    private boolean usingTelemedicine;
    public Nurse(String name, double resolveProb, double telemedicineProb) {
        this.name              = name;
        this.resolveProb       = resolveProb;
        this.telemedicineProb  = telemedicineProb;
        this.currentAlert      = null;
        this.usingTelemedicine = false;
    }
    public String getName()   { return name; }
    public boolean hasAlert() { return currentAlert != null; }
    private boolean attempt(double probability) {
        return Simulation.getRandom().nextDouble() < probability;
    }
    public int resolve(Hospital hospital, int time,
                       Queue completedAlerts,
                       int telemedicineSlots, int maxTelemedicineSessions) {
        if (currentAlert == null) {
            currentAlert = hospital.getNextAlert();
            usingTelemedicine = false;
        }
        while (currentAlert != null) {
            if (!usingTelemedicine && telemedicineSlots < maxTelemedicineSessions) {
                usingTelemedicine = true;
                telemedicineSlots++;
                System.out.println("  [TELEMEDICINE] " + name + " started a session.");
            }
            boolean resolved = attempt(resolveProb);
            if (!resolved && usingTelemedicine) {
                resolved = attempt(telemedicineProb);
                if (resolved) {
                    System.out.println("  [TELEMEDICINE] " + name + " resolved with help.");
                }
            }
            if (resolved) {
                currentAlert.resolve(time);
                System.out.println("  [RESOLVED] " + name + " resolved: " + currentAlert);
                completedAlerts.enqueue(currentAlert);
                if (usingTelemedicine) {
                    telemedicineSlots--;
                    usingTelemedicine = false;
                }
                currentAlert = null;
                currentAlert = hospital.getNextAlert();
            } else {
                System.out.println("  [PENDING] " + name
                        + " still working on: " + currentAlert);
                break;
            }
        }
        return telemedicineSlots;
    }
}