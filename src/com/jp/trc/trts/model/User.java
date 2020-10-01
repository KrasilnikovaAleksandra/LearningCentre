package com.jp.trc.trts.model;

/**
 * This base class. It will be inherited class-role.
 */
public class User {

    private int id;
    private String login;
    private String password;
    private String name;
    private String secondName;
    private String role;

    /**
     * It is default constructor.
     */
    public User() {
    }

    /**
     * It is constructor. For all
     *
     * @param login      is it login of the user
     * @param password   is it password of the user
     * @param name       is it name of the user
     * @param secondName is it secondName of the user
     */
    public User(int id, String login, String password, String name, String secondName, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.secondName = secondName;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getRole() {
        return role;
    }
}
