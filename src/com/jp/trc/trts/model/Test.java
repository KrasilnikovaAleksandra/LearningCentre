package com.jp.trc.trts.model;

/**
 * This class that describes the object "Test"
 */
public class Test {

    private int id;
    private String name;
    private int countQuestion;

    /**
     *  It is constructor.
     * @param id
     * @param name
     */
    public Test(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getCountQuestion() {
        return countQuestion;
    }

    public void setCountQuestion(int countQuestion) {
        this.countQuestion = countQuestion;
    }
}

