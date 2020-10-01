package com.jp.trc.trts;

import com.jp.trc.trts.controller.*;
import com.jp.trc.trts.view.BasicView;

/**
 * This class starts of the application.
 *
 * @author Krasilnikova
 * @version 3.0
 */
public class Main {

    /**
     * This method creates main controller and view.
     *
     * @param args
     */
    public static void main(String[] args) {

        ControllerWithStaticData staticData = new ControllerWithStaticData();
        UserController userController = new UserController();
        GroupController groupController = new GroupController();
        TestController testController = new TestController();
        TestResultController testResultController = new TestResultController();
        CountRatingController countRatingController = new CountRatingController();
        BasicView view = new BasicView(userController, staticData, groupController, testController, testResultController,
                countRatingController);
        userController.setBasicView(view);
        view.authorize();
    }
}