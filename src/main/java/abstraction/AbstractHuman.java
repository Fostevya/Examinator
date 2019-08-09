package abstraction;

public abstract class AbstractHuman {

    private String firstName;
    private String surName;
    private String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return lastName + " " + firstName + " " + surName;
    }

}
