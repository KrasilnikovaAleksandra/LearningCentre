package com.jp.trc.trts.controller;

import com.jp.trc.trts.model.Student;
import com.jp.trc.trts.model.Teacher;
import com.jp.trc.trts.model.TestResult;
import com.jp.trc.trts.model.User;
import com.jp.trc.trts.view.BasicView;

import java.util.ArrayList;

/**
 * This class is the main controller of the work with the user.
 */
public class UserController {

    private User[] listUsers;
    private User currentUser;
    private BasicView basicView;
    private String result = "";
    // private ArrayList<Student> allStudents;

    /**
     * It is constructor.
     */
    public UserController() {
        currentUser = new User();
    }

    public void setBasicView(BasicView basicView) {
        this.basicView = basicView;
    }

    /**
     * This method checks the login and the password which the user written.
     *
     * @param currentUser
     * @return the method returns the marker of the successful or unsuccessful authorization.
     */
    public boolean authorize(User currentUser, ControllerWithStaticData staticData) {
        listUsers = staticData.getUsers();
        boolean error = false;
        for (User user : listUsers) {
            if (user.getLogin().equals(currentUser.getLogin()) && user.getPassword().equals(currentUser.getPassword())) {
                this.currentUser = user;
                error = false;
                break;
            } else {
                error = true;
            }
        }
        return error;
    }

    /**
     * This method defines the role of the user.
     *
     * @return
     */
    public String defineRole(GroupController groupController, TestController testController, TestResultController testResultController,
                             CountRatingController countRatingController) {
        String nameRole = currentUser.getRole();
        if (nameRole == "admin") {
            result += logicForAdmin();
        }
        if (nameRole == "student") {
            result = logicForStudent(currentUser, groupController, testController);
        }
        if (nameRole == "teacher") {
            result = logicForTeacher(currentUser, groupController, testController, testResultController, countRatingController);
        }
        return result;
    }

    private String logicForAdmin() {
        result += "Имя пользователя | Фамилия пользователя | Роль\n";
        for (User user : listUsers) {
            result += user.getName() + " | " + user.getSecondName() + " | " + user.getRole() + "\n";
        }
        return result;
    }

    private String logicForStudent(User currentUser, GroupController groupController, TestController testController) {
        result += "Название теста | Количество вопросов\n";
        Student student = (Student) currentUser;
        int idGroupCurrentStudent = student.getIdGroup();
        int[] listIdTests = groupController.defineListIdTests(idGroupCurrentStudent);
        testController.defineNameTests(listIdTests);
        for (int i = 0; i < testController.getMasNameTests().size(); i++) {
            result += testController.getMasNameTests().get(i) + "|" + testController.getMasCountQuestion().get(i) + "\n";
        }
        return result;
    }

    private int searchGroups(Teacher teacher, GroupController groupController) {
        String stringNameAllGroupsCurrentTeacher = "";
        int[] listIdGroupCurrentTeacher = teacher.getListIdGroup();
        stringNameAllGroupsCurrentTeacher = groupController.defineNameGroups(listIdGroupCurrentTeacher);
        return basicView.choiceParametersSearchForLogicOfTeacher(stringNameAllGroupsCurrentTeacher, "группу");
    }

    private int searchTests(int numberGroup, GroupController groupController, TestController testController) {
        String stringNameAllTestsCurrentTeacher = "";
        int counter = 0;
        int[] listIdTestsCurrentTeacher = groupController.defineListIdTests(numberGroup);
        testController.defineNameTests(listIdTestsCurrentTeacher);
        for (int i = 0; i < testController.getMasNameTests().size(); i++) {
            stringNameAllTestsCurrentTeacher += counter + ") " + testController.getMasNameTests().get(i) + "\n";
            counter++;
        }
        return basicView.choiceParametersSearchForLogicOfTeacher(stringNameAllTestsCurrentTeacher, "тест");
    }

    private ArrayList<Student> defineAllStudents() {
        ArrayList<Student> allStudents = new ArrayList<>();
        for (User user : listUsers) {
            if (user.getRole() == "student") {
                allStudents.add((Student) user);
            }
        }
        return allStudents;
    }

    private ArrayList<Student> searchStudentsSelectedGroup(int numberGroup, ArrayList<Student> allStudents) {
        ArrayList<Student> studentsSelectedGroup = new ArrayList<>();
        for (Student student : allStudents) {
            if (student.getIdGroup() == numberGroup) {
                studentsSelectedGroup.add(student);
            }
        }
        return studentsSelectedGroup;
    }

    private ArrayList<Student> searchStudentsAllGroupsTeacher(int[] idGroups, ArrayList<Student> allStudents) {
        ArrayList<Student> studentsTeachers = new ArrayList<>();
        for (int idGroup : idGroups) {
            for (Student student : allStudents) {
                if (student.getIdGroup() == idGroup) {
                    studentsTeachers.add(student);
                }
            }
        }
        return studentsTeachers;
    }

    private void searchTestResult(ArrayList<Student> allStudents, ArrayList<Student> studentsSelectedGroup, int numberTest,
                                  TestResultController testResultController, TestController testController) {
        result += "Имя студента | Фамилия студента  |      Количество правильных ответов в тесте     | Всего вопросов  \n";
        testResultController.defineTestResultsCurrentTeacher(studentsSelectedGroup, numberTest);
        for (int i = 0; i < testResultController.getMasIdStudents().size(); i++) {
            result += searchNameStudent(testResultController.getMasIdStudents().get(i), allStudents) + " " + testResultController.getListRightAnswer().get(i) +
                    " " + testController.getMasCountQuestion().get(numberTest) + "\n";////////
        }
    }


    private String searchNameStudent(int id, ArrayList<Student> allStudents) {
        for (Student student : allStudents) {
            if (student.getId() == id) {
                return student.getName() + " " + student.getSecondName();
            }
        }
        return null;
    }




    private void countRatingStudentsSelectedGroup(ArrayList<Student> allStudents, ArrayList<Student> studentsSelectedGroup,
                                                  CountRatingController countRatingController, TestResultController testResultController
                                                  ) {
         //int [] listIdTestsSelectedGroup = groupController.defineListIdTests(numberGroup);
        countRatingController.countRatingStudentsInSelectedGroup(studentsSelectedGroup);
        result += "Имя студента | Фамилия студента  | Рейтинг \n";
        ArrayList <String> listResult = new ArrayList<>();
        for (int i = 0; i < countRatingController.getSizeListRatingAllStudent(); i++) {
            /*result += searchNameStudent(countRatingController.getElementListIdStudents(i), allStudents )  + " " +
                    countRatingController.getElementListRatingAllStudent(i) +"\n";*/
            listResult.add(searchNameStudent(countRatingController.getElementListIdStudents(i), allStudents )  + " " +
                    countRatingController.getElementListRatingAllStudent(i) +"\n");
        }


    }


    private int defineFunctionForTeacher() {
        String stringNameFunctionForTeacher = "1) Отобразить количество решенных тестов в группе " +
                "\n" + "2) Отобразить рейтинг всех учеников " +
                "\n" + "3) Отобразить рейтинг всех учеников в группе";
        return basicView.choiceParametersSearchForLogicOfTeacher(stringNameFunctionForTeacher, "");
    }

    private String logicForTeacher(User currentUser, GroupController groupController, TestController testController,
                                   TestResultController testResultController, CountRatingController countRatingController) {
        int numberFunction = defineFunctionForTeacher();
        Teacher teacher = (Teacher) currentUser;
        ArrayList<Student> allStudents = defineAllStudents();

        switch (numberFunction) {
            case 1: {
                int numberGroup = searchGroups(teacher, groupController);
                int numberTest = searchTests(numberGroup, groupController, testController);
                ArrayList<Student> studentsSelectedGroup = searchStudentsSelectedGroup(numberGroup, allStudents);
                searchTestResult(allStudents, studentsSelectedGroup, numberTest, testResultController, testController);
            }
            break;
            case 2: {
                int[] listIdGroupCurrentTeacher = teacher.getListIdGroup();
                ArrayList<Student> allStudentsTeachers = searchStudentsAllGroupsTeacher(listIdGroupCurrentTeacher, allStudents);
                //countRatingAllStudentsTeacher(allStudentsTeachers, countRatingController, testResultController);

            }
            break;
            case 3: {
                int numberGroup = searchGroups(teacher, groupController);
                ArrayList<Student> studentsSelectedGroup = searchStudentsSelectedGroup(numberGroup, allStudents);
                countRatingStudentsSelectedGroup(allStudents, studentsSelectedGroup, countRatingController, testResultController);
               // result += countRatingController.s() + "\n\n" + countRatingController.s2();
            }
            break;

        }
        return result;
    }
}