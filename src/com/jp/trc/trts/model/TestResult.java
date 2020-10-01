package com.jp.trc.trts.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class that describes the student's testing results
 */
public class TestResult {

    private int id;
    private int idStudent;
    private int idTest;
    private List<Integer> countRightAnswerInTests;
    private int topList;//пересчитанный рейтинг последнего прохождения теста

    /**
     * It is constructor.
     *
     * @param id
     * @param idStudent
     * @param idTest
     * @param
     */
    public TestResult(int id, int idStudent, int idTest, int countRightAnswerInOneTest) {
        this.id = id;
        this.idStudent = idStudent;
        this.idTest = idTest;
        countRightAnswerInTests = new ArrayList<>();

        countRightAnswerInTests.add(countRightAnswerInOneTest);
    }

      public void setCountRightAnswerInTest(int count) {
        this.countRightAnswerInTests.add(count);
    }

    /*public void setElementTopList(int elementTopList) {
        this.topList.add(elementTopList);
    }*/

    public int getIdStudent() {
        return idStudent;
    }

    public int getIdTest() {
        return idTest;
    }

   /* public ArrayList <Integer> getTopList() {
        return  topList;
    }*/


    public void setTopList(int topList) {
     this.topList = topList;
    }

    public int getTopList() {
        return topList;
    }
    public ArrayList<Integer> getCountRightAnswerInTests() {
        return (ArrayList) countRightAnswerInTests;
    }
}