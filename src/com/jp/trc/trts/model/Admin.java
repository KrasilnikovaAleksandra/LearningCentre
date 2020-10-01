package com.jp.trc.trts.model;

/**
 * This class that describes the user with role "Admin"
 */
public class Admin extends User {

    /**
     * It is constructor.
     *
     * @param login
     * @param password
     * @param name
     * @param secondName
     */
    public Admin(int id, String login, String password, String name, String secondName) {
        super(id, login, password, name, secondName, "admin");
    }
}
