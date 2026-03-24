public class Alert {

    private Observation observation;
    private int timeRaised;
    private int timeResolved;

    private boolean urgent;

    public Alert(Observation obs, int time, boolean isUrgent) {
        observation = obs;
        timeRaised = time;
        urgent = isUrgent;
        timeResolved = -1;
    }

    public Observation getObservation() {
        return observation;
    }

    public int getTimeRaised() {
        return timeRaised;
    }

    public int getTimeResolved() {
        return timeResolved;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public boolean isResolved() {
        return timeResolved >= 0;
    }

    public void resolve(int time) {
        timeResolved = time;
    }

    public String toString() {
        String severityText;
        if (urgent) {
            severityText = "URGENT";
        } else {
            severityText = "ROUTINE";
        }

        String resolvedText = "unresolved";
        if (isResolved()) {
            resolvedText = "resolved" + timeResolved;
        }

        return "ALERT [" + severityText + "] raised" + timeRaised + " " + resolvedText
                + " :: " + observation.data();
    }
}