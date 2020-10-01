package com.jp.trc.trts.controller;

import com.jp.trc.trts.model.*;

import java.util.ArrayList;

/**
 * This class is the controller which creates the static data.
 */
public class ControllerWithStaticData {

    private User[] users;
    private Group[] groups;
    private Test[] tests;
    private Question[] questions;
    private Admin[] admins;
    private Teacher[] teachers;
    private Student[] students;
    private ArrayList<TestResult> testResults;
    private String[] nameUsers;
    private String[] secondNameUsers;


    /**
     * It is constructor.
     */
    public ControllerWithStaticData() {
        createListNameUsers();
        createListSecondNameUsers();
        createListUsers();
        addGroupsForUsers();
        createListQuestions();
        createListTests();
        addQuestionsTests();
        addTestsForTeachers();
        addTestsForGroup();
        countNumberQuestionInTests();
        createListTestResults();
    }

    private void createListNameUsers() {
        nameUsers = new String[]{"Alexander", "Mark", "Ben", "Olivia", "Amelia", "Jack", "Joseph", "Scarlett"};
    }

    private void createListSecondNameUsers() {
        secondNameUsers = new String[]{"Brown", "Smith", "Miller", "Baker", "Green", "Ross"};
    }

    private void createListUsers() {
        admins = new Admin[2];
        teachers = new Teacher[5];
        students = new Student[50];
        for (int i = 0; i < admins.length; i++) {
            admins[i] = new Admin(i, "admin" + i, "a" + i, "nameAdmin" + i, "secondNameAdmin" + i);
        }
        for (int i = 0; i < teachers.length; i++) {
            teachers[i] = new Teacher(i, "teacher" + i, "t" + i, "nameTeacher" + i,
                    "secondNameTeacher" + i);
        }
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i, "student" + i, "s" + i, addNameUser(), addSecondNameUser());
        }
    }

    private String addNameUser() {
        int indexListNameStudent = (int) (Math.random() * nameUsers.length);
        return nameUsers[indexListNameStudent];
    }

    private String addSecondNameUser() {
        int indexListSecondNameStudent = (int) (Math.random() * secondNameUsers.length);
        return secondNameUsers[indexListSecondNameStudent];
    }

    private void addGroupsForUsers() {
        groups = new Group[5];
        for (int i = 0; i < groups.length; i++) {
            groups[i] = new Group(i, "group" + i);
        }
        for (int i = 0; i < 10; i++) {
            students[i].setIdGroup(0);
        }
        for (int i = 10; i < 20; i++) {
            students[i].setIdGroup(1);
        }
        for (int i = 20; i < 30; i++) {
            students[i].setIdGroup(2);
        }
        for (int i = 30; i < 40; i++) {
            students[i].setIdGroup(3);
        }
        for (int i = 40; i < 50; i++) {
            students[i].setIdGroup(4);
        }
        teachers[0].setListIdGroup(new int[]{0});
        teachers[1].setListIdGroup(new int[]{0, 1, 2, 3, 4});
        teachers[2].setListIdGroup(new int[]{0, 1, 2, 3, 4});
        teachers[3].setListIdGroup(new int[]{0, 1});
        teachers[4].setListIdGroup(new int[]{0, 1});
    }

    private void createListQuestions() {
        questions = new Question[20];
        for (int i = 0; i < 10; i += 3) {
            questions[i] = new Question(i, "stringQuestionForQuestion" + i, new String[]{"numberAnswer1", "numberAnswer2",
                    "numberAnswer3"}, 1);
            questions[i + 1] = new Question((i + 1), "stringQuestionForQuestion" + (i + 1), new String[]{"numberAnswer1", "numberAnswer2",
                    "numberAnswer3"}, 2);
            questions[i + 2] = new Question((i + 2), "stringQuestionForQuestion" + (i + 2), new String[]{"numberAnswer1", "numberAnswer2",
                    "numberAnswer3"}, 3);
        }
        for (int i = 10; i < questions.length; i += 2) {
            questions[i] = new Question(i, "stringQuestionForQuestion" + i, new String[]{"numberAnswer1", "numberAnswer2"}, 1);
            questions[i + 1] = new Question((i + 1), "stringQuestionForQuestion" + (i + 1), new String[]{"numberAnswer1", "numberAnswer2"},
                    2);
        }
    }

    private void createListTests() {
        tests = new Test[5];
        for (int i = 0; i < tests.length; i++) {
            tests[i] = new Test(i, "test" + i);
        }
    }

    private void addQuestionsTests() {
        for (int i = 0; i < 10; i++) {
            questions[i].setIdTests(new int[]{0, 1, 2, 3, 4});
        }
        for (int i = 10; i < 20; i++) {
            questions[i].setIdTests(new int[]{0});
        }
    }

    private void addTestsForTeachers() {
        teachers[0].setListIdTest(new int[]{0, 1, 2, 3, 4});
        teachers[1].setListIdTest(new int[]{0});
        teachers[2].setListIdTest(new int[]{4});
    }

    private void createListTestResults() {
        testResults = new ArrayList<>();
        int idGroup = groups[0].getId();
        int[] idTests = groups[0].getIdTests();
        ArrayList<Integer> idStudents = new ArrayList<Integer>();
        for (Student student : students)
            if (student.getIdGroup() == idGroup) {
                idStudents.add(student.getId());
            }
        int indexId = 0;
        for (Test test : tests) {
            for (int idTest : idTests) {
                if (test.getId() == idTest) {
                    int countQuestionInTest = test.getCountQuestion();
                    for (int i = 0; i < idStudents.size(); i++) {
                        testResults.add(new TestResult(indexId, idStudents.get(i), test.getId(),
                                (int) (Math.random() * countQuestionInTest)));
                        indexId++;
                    }
                }
            }
        }

        testResults.get(0).setCountRightAnswerInTest((int) (Math.random() * tests[0].getCountQuestion()));
        testResults.get(0).setCountRightAnswerInTest((int) (Math.random() * tests[0].getCountQuestion()));
        testResults.get(0).setCountRightAnswerInTest((int) (Math.random() * tests[0].getCountQuestion()));
        testResults.get(0).setCountRightAnswerInTest((int) (Math.random() * tests[0].getCountQuestion()));

    }

    /*private double countTopList(int countRightAnswer, int countQuestionInTest) {
        return (double) (countRightAnswer * 100) / countQuestionInTest;
    }*/

    private void addTestsForGroup() {
        groups[0].setIdTests(new int[]{0, 1, 2, 3, 4});
        groups[1].setIdTests(new int[]{0});
        groups[2].setIdTests(new int[]{0});
        groups[3].setIdTests(new int[]{0});
        groups[4].setIdTests(new int[]{0, 1, 2, 3, 4});
    }

    private void countNumberQuestionInTests() {
        int countQuestionsInTest = 0;
        for (Test test : tests) {
            for (Question question : questions) {
                for (int i = 0; i < question.getIdTests().length; i++)
                    if (test.getId() == question.getIdTests()[i]) {
                        countQuestionsInTest++;
                    }
            }
            test.setCountQuestion(countQuestionsInTest);
            countQuestionsInTest = 0;
        }
    }

    /***
     * This method creates a shared user table
     * @return
     */
    public User[] getUsers() {
        users = new User[admins.length + teachers.length + students.length];
        int indexUsers = 0;
        for (int i = 0; i < admins.length; i++) {
            users[indexUsers] = admins[i];
            indexUsers++;
        }
        for (int i = 0; i < teachers.length; i++) {
            users[indexUsers] = teachers[i];
            indexUsers++;
        }
        for (int i = 0; i < students.length; i++) {
            users[indexUsers] = students[i];
            indexUsers++;
        }
        return users;
    }

    public Group[] getGroups() {
        return groups;
    }

    public Test[] getTests() {
        return tests;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public ArrayList<TestResult> getTestResult() {
        return testResults;
    }
}
