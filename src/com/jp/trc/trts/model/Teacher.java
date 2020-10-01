package com.jp.trc.trts.model;

/**
 * This class that describes the user with role "Teacher"
 */
public class Teacher extends User {

    private int[] listIdGroup;
    private int[] listIdTest;

    /**
     * It is constructor.
     *
     * @param id
     * @param login
     * @param password
     * @param name
     * @param secondName
     */
    public Teacher(int id, String login, String password, String name, String secondName) {
        super(id, login, password, name, secondName, "teacher");
    }

    public int[] getListIdGroup() {
        return listIdGroup;
    }

    public int[] getListIdTest() {
        return listIdTest;
    }

    public void setListIdGroup(int[] listIdGroup) {
        this.listIdGroup = listIdGroup;
    }

    public void setListIdTest(int[] listIdTest) {
        this.listIdTest = listIdTest;
    }
}