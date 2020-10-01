package com.jp.trc.trts.model;

/**
 * This class that describes the user with role "Student"
 */
public class Student extends User {

    private int idGroup;
    private int ratingAllTests;
    /**
     * It is constructor.
     *
     * @param login
     * @param password
     * @param name
     * @param secondName
     */
    public Student(int id, String login, String password, String name, String secondName) {
        super(id, login, password, name, secondName, "student");
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public int getRatingAllTests() {
        return ratingAllTests;
    }

    public void setRatingAllTests(int ratingAllTests) {
        this.ratingAllTests = ratingAllTests;
    }
}
