package com.jp.trc.trts.model;

/**
 * This  class that describes the question.
 */
public class Question {

    private int id;
    private String stringOfQuestion;
    private String[] answerChoice;
    private int numberRightChoice;
    private int[] idTests;

    /**
     * It is constructor.
     *
     * @param id
     * @param stringOfQuestion
     * @param answerChoice
     * @param numberRightChoice
     */
    public Question(int id, String stringOfQuestion, String[] answerChoice, int numberRightChoice) {
        this.id = id;
        this.stringOfQuestion = stringOfQuestion;
        this.answerChoice = answerChoice;
        this.numberRightChoice = numberRightChoice;
    }

    public int[] getIdTests() {
        return idTests;
    }

    public void setIdTests(int[] idTests) {
        this.idTests = idTests;
    }
}