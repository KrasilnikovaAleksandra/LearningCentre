package com.jp.trc.trts.view;

import java.util.Scanner;

import com.jp.trc.trts.controller.*;
import com.jp.trc.trts.model.User;

/**
 * This class is the basic view.
 */
public class BasicView {

    private UserController userController;
    private ControllerWithStaticData staticData;
    private GroupController groupController;
    private TestController testController;
    private TestResultController testResultController;
    private CountRatingController countRatingController;

    /**
     * It is constructor.
     *
     * @param userController
     */
    public BasicView(UserController userController, ControllerWithStaticData staticData, GroupController groupController,
                     TestController testController, TestResultController testResultController, CountRatingController countRatingController) {
        this.userController = userController;
        this.staticData = staticData;
        this.groupController = groupController;
        this.testController = testController;
        this.testResultController = testResultController;
        this.countRatingController = countRatingController;
    }

    /**
     * This method reads the entered login and password with the console.
     */
    public void authorize() {
        User user = new User();
        String currentLogin, currentPassword;
        Scanner s = new Scanner(System.in);
        System.out.println("Вход в систему");
        System.out.print("Введите логин");
        currentLogin = s.nextLine();
        System.out.print("Введите пароль");
        currentPassword = s.nextLine();
        user.setLogin(currentLogin);
        user.setPassword(currentPassword);
        boolean markerErrorAuthorization = userController.authorize(user, staticData);
        writeOnConsoleResultAuthorize(markerErrorAuthorization);
        if (!markerErrorAuthorization) {
            String resultString = userController.defineRole(groupController, testController, testResultController, countRatingController);
            writeOnConsole(resultString);
        }
    }

    /**
     * This method writes on the console the result of the authorize.
     *
     * @param keyError
     */
    public void writeOnConsoleResultAuthorize(boolean keyError) {
        String resultString;
        if (keyError) {
            resultString = "Пользователя с введенными логином и паролем не существует!";
        } else {
            resultString = "Авторизация прошла успешно!!!";
        }
        System.out.println(resultString);
    }

    /**
     * This method writes on the console.
     *
     * @param resultString
     */
    public void writeOnConsole(String resultString) {
        System.out.println(resultString);
    }

    /**
     * This method writes on the console the list of the parameters. The user must choice the parameter.
     *
     * @param listParameters
     * @param stringParameterChoice
     * @return
     */
    public int choiceParametersSearchForLogicOfTeacher(String listParameters, String stringParameterChoice) {
        System.out.println("Выберете " + stringParameterChoice);
        System.out.println(listParameters);
        Scanner s = new Scanner(System.in);
        System.out.print("Ваш выбор - ");
        return s.nextInt();
    }
}
