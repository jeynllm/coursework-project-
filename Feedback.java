// Feedback.java
public class Feedback {
    private String id;
    private String name;
    private String email;
    private String comment;
    private String rating;

    public Feedback(String id, String name, String email, String comment, String rating) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.comment = comment;
        this.rating = rating;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getComment() { return comment; }
    public String getRating() { return rating; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setComment(String comment) { this.comment = comment; }
    public void setRating(String rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nEmail: " + email +
                "\nComment: " + comment + "\nRating: " + rating;
    }

    public String toCSV() {
        return id + "," + name + "," + email + "," + comment + "," + rating;
    }

    public static Feedback fromCSV(String csvLine) {
        String[] parts = csvLine.split(",", -1);
        if (parts.length == 5) {
            return new Feedback(parts[0], parts[1], parts[2], parts[3], parts[4]);
        }
        return null;
    }
}
