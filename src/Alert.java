public class Alert {
    private Observation observation;
    private int timeRaised;
    private int timeResolved;
    private StarRating starRating;
    private boolean urgent;

    public Alert(Observation obs, int time, StarRating rating) {
        observation  = obs;
        timeRaised   = time;
        starRating   = rating;
        urgent       = rating.isUrgent();
        timeResolved = -1;
    }

    public Alert(Observation obs, int time, boolean isUrgent) {
        observation  = obs;
        timeRaised   = time;
        urgent       = isUrgent;
        starRating   = new StarRating(isUrgent ? 5 : 2);
        timeResolved = -1;
    }

    public Alert(Observation obs, int time, int stars) {
        observation  = obs;
        timeRaised   = time;
        starRating   = new StarRating(stars);
        urgent       = starRating.isUrgent();
        timeResolved = -1;
    }

    public Observation getObservation() { return observation; }
    public int getTimeRaised()          { return timeRaised; }
    public int getTimeResolved()        { return timeResolved; }
    public StarRating getStarRating()   { return starRating; }
    public int getStars()               { return starRating.getStars(); }
    public boolean isUrgent()           { return urgent; }
    public boolean isResolved()         { return timeResolved >= 0; }

    public void resolve(int time) {
        timeResolved = time;
    }

    public int resolutionTime() {
        return timeResolved - timeRaised;
    }

    public String toString() {
        String severityText = urgent ? "URGENT" : "ROUTINE";
        String resolvedText = isResolved()
                ? "resolved@" + timeResolved
                : "unresolved";
        return "ALERT [" + severityText + "] " + starRating
                + " raised@" + timeRaised
                + " " + resolvedText
                + " :: " + (observation != null ? observation.data() : "null");
    }
}