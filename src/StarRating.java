public class StarRating {
    public static final int MIN_STARS = 1;
    public static final int MAX_STARS = 5;
    private int stars;

    public StarRating(int stars) {
        if (stars < MIN_STARS || stars > MAX_STARS) {
            throw new IllegalArgumentException(
                    "Star rating must be between " + MIN_STARS + " and " + MAX_STARS);
        }
        this.stars = stars;
    }

    public static StarRating random() {
        int stars = MIN_STARS + Simulation.getRandom().nextInt(MAX_STARS);
        return new StarRating(stars);
    }

    public int getStars()     { return stars; }
    public boolean isUrgent() { return stars >= 4; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_STARS; i++) {
            sb.append(i < stars ? "*" : "-");
        }
        return sb.toString() + " (" + stars + "/5)";
    }
}