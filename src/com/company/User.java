package com.company;

import java.time.LocalDate;

public class User {
    private String email,id,firstName,lastName;
    private LocalDate birthDate;

    /**
     * Constructor for User class.
     * @param email
     * @param id
     * @param firstName
     * @param lastName
     * @param year
     * @param month
     * @param day
     */
    public User(String email, String id, String firstName, String lastName, int year, int month, int day) {
        this.email = email;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate= LocalDate.of(year,month,day);
    }

    /**
     *
     * @return String email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Takes String parameter for the email.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return String Id
     */
    public String getId() {
        return id;
    }

    /**
     * Takes String parameter for Id.
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return String first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Takes String parameter for first name of the user.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return String last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Takes String parameter for user last name.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns user birthDate
     * @return LocalDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Takes LocalDate parameter for users birthDate.
     * @param birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
