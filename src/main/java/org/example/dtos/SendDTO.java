package org.example.dtos;


import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@SuppressWarnings("unused")
@Entity("Sends")
public class SendDTO {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private int participation;

    @SuppressWarnings("unused")
    public SendDTO() { }

    @SuppressWarnings("unused")
    public SendDTO(String firstName, String lastName, int participation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.participation = participation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getParticipation() {
        return participation;
    }

    public void setParticipation(int participation) {
        this.participation = participation;
    }
}
