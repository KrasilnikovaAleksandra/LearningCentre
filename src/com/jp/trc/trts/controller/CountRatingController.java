package com.jp.trc.trts.controller;

import com.jp.trc.trts.model.Student;
import com.jp.trc.trts.model.Teacher;
import com.jp.trc.trts.model.Test;
import com.jp.trc.trts.model.TestResult;

import java.util.ArrayList;
import java.util.List;

public class CountRatingController {

    private ArrayList<TestResult> listTestResults;
    private ControllerWithStaticData staticData;
    private ArrayList<Integer> listIdStudents;
    ArrayList<Integer> listRatingAllStudent;
    private Test[] listTests;
    private String resultString = "";
    private String resultString2 = "";
    /**
     * It is constructor.
     */
    public CountRatingController() {
        staticData = new ControllerWithStaticData();
        listTestResults = staticData.getTestResult();
        listTests = staticData.getTests();
        listIdStudents = new ArrayList<>();
        listRatingAllStudent = new ArrayList<>();
    }

    private int countMaxGrade(int[] listIdTestsSelectedGroup) {
        int max = 0;
        for (Test test : listTests) {
            for (int idTestSelectedGroup : listIdTestsSelectedGroup) {
                if (idTestSelectedGroup == test.getId()) {
                    max += test.getCountQuestion();
                }
            }
        }
        return max;
    }

    private int maxCountQuestionInTest(int idTestSelectedGroup) {
        int max = 0;
        for (Test test : listTests) {
            if (idTestSelectedGroup == test.getId()) {
                max += test.getCountQuestion();
            }
        }
        return max;
    }


    public void countRatingStudentsInSelectedGroup(ArrayList<Student> studentsSelectedGroup) {


        for (int i = 0; i < studentsSelectedGroup.size(); i++) {
            listIdStudents.add(studentsSelectedGroup.get(i).getId());
        }
        //listRightAnswer = new ArrayList<>();
        int rating = 0;
        for (int idStudent : listIdStudents){
            for (TestResult testResult : listTestResults) {
                if (testResult.getIdStudent() == idStudent) {
                    int idTest = testResult.getIdTest();
                    int max = maxCountQuestionInTest(idTest);
                    ArrayList<Integer> countRightAnswerInTestsCurrentStudent = testResult.getCountRightAnswerInTests();

                    //cчитаем последний результат теста
                    rating = (countRightAnswerInTestsCurrentStudent.get(countRightAnswerInTestsCurrentStudent.size() - 1) * 10)/ max;
                    testResult.setTopList(rating);
                    // listRatingStudent.add(rating);
                    resultString += idStudent + " " + idTest + " " + countRightAnswerInTestsCurrentStudent + " "+ rating + " "+
                            max  +  "\n";
                }
            }
        }

        ArrayList<Integer> listRatingStudent = new ArrayList<>();
        rating=0;
        for (int i = 0; i < listIdStudents.size(); i++) {
            for (TestResult testResult : listTestResults) {
                if (testResult.getIdStudent() == listIdStudents.get(i)) {
                    listRatingStudent.add(testResult.getTopList());

                }
            }
            for (int ii : listRatingStudent) {
                rating += ii;
                resultString2 += ii + " ";
            }
            resultString2 += "\n";
            rating = rating / listRatingStudent.size();
            listRatingAllStudent.add(rating);
            resultString2 +=listIdStudents.get(i) + " " + rating  + "\n";
            rating = 0;
            listRatingStudent.clear();
            //запись в студента в контроллере студента
        }
    }

    public String s (){
        return resultString;
    }

    public String s2 (){
        return resultString2;
    }

    public int getElementListRatingAllStudent(int index) {
        return listRatingAllStudent.get(index);
    }
    public int getSizeListRatingAllStudent() {
        return listRatingAllStudent.size();
    }

    public int getElementListIdStudents(int index) {
        return listIdStudents.get(index);
    }

    public int getCountListIdStudents() {
        return listIdStudents.size();
    }

   /* public ArrayList<TestResult> getListTestResults() {
        return listTestResults;
    }*/

    public TestResult getListTestResults(int index) {
        return listTestResults.get(index);
    }

    public int getCountListTestResults() {
        return listTestResults.size();
    }
}
