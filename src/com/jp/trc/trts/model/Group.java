package com.jp.trc.trts.model;

/**
 * This class that describes the group for the user.
 */
public class Group {

    private int id;
    private String name;
    private int[] idTests;

    /**
     * It is constructor.
     *
     * @param id
     * @param name
     */
    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int[] getIdTests() {
        return idTests;
    }

    public void setIdTests(int[] idTests) {
        this.idTests = idTests;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}