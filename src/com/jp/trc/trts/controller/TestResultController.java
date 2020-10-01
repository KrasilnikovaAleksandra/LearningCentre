package com.jp.trc.trts.controller;

import com.jp.trc.trts.model.Student;
import com.jp.trc.trts.model.TestResult;

import java.util.ArrayList;

/**
 * This class is the controller which work with test results.
 */
public class TestResultController {

    private ArrayList<TestResult> listTestResults;
    private ControllerWithStaticData staticData;
    private ArrayList<Integer> listIdStudents;
    /*private ArrayList<ArrayList<Double>> listIdTopLists;*/
   private ArrayList<ArrayList<Integer>> listRightAnswer;

    /**
     * It is constructor.
     */
    public TestResultController() {
        staticData = new ControllerWithStaticData();
        listTestResults = staticData.getTestResult();
        listIdStudents = new ArrayList<>();
    }

    /**
     * This method defines test results of students of the specific group and the specific test.
     *
     * @param studentsSelectedGroup
     * @param numberTest
     */
    public void defineTestResultsCurrentTeacher(ArrayList<Student> studentsSelectedGroup, int numberTest) {
        for (int i = 0; i < studentsSelectedGroup.size(); i++) {
            listIdStudents.add(studentsSelectedGroup.get(i).getId());
        }
        listRightAnswer = new ArrayList<>();
        for (TestResult testResult : listTestResults) {
            for (int idStudent : listIdStudents) {
                if (testResult.getIdStudent() == idStudent && testResult.getIdTest() == numberTest) {
                    listRightAnswer.add(testResult.getCountRightAnswerInTests());
                }
            }
        }
    }

    public ArrayList<Integer> getMasIdStudents() {
        return listIdStudents;
    }

    /*public ArrayList<ArrayList<Double>> getMasIdTopLists() {
        return listIdTopLists;*/

    public ArrayList<ArrayList<Integer>> getListRightAnswer() {
        return listRightAnswer;
    }

    public ArrayList<TestResult> getListTestResults() {
        return listTestResults;
    }
}
