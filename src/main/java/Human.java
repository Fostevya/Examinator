abstract public class Human {

    private String firstName = "";
    private String surName = "";
    private String lastName = "";

    private short iq = 0;
    private double moodFactor = 0.0;

    protected String getFirstName() {
        return firstName;
    }

    protected String getSurName() {
        return surName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected double getIq() {
        return iq;
    }

    protected String getName() {
        return lastName + " " + firstName + " " + surName;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    protected void setSurName(String surName) {
        this.surName = surName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected void setIq(short iq) {
        this.iq = iq;
    }

    protected void setIq(String iq) {
        this.iq = Short.parseShort(iq);
    }

    protected void setMoodFactor(double moodFactor) { this.moodFactor = moodFactor; }

    protected double getMoodFactor() { return this.moodFactor; }
}
