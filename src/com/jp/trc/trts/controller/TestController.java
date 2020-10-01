package com.jp.trc.trts.controller;

import com.jp.trc.trts.model.Test;
import java.util.ArrayList;

/**
 * This class is the controller which works with tests.
 */
public class TestController {

    private Test[] listTests;
    private ControllerWithStaticData staticData;
    private ArrayList<String> masNameTests;
    private ArrayList<Integer> masCountQuestion;

    /**
     * It is constructor.
     */
    public TestController() {
        staticData = new ControllerWithStaticData();
        listTests = staticData.getTests();
    }

    /**
     * This method defines names of the tests by ID.
     * @param listIdTests
     */
    public void defineNameTests(int[] listIdTests) {
        masNameTests = new ArrayList<>();
        masCountQuestion = new ArrayList<>();
        for (int i = 0; i < listIdTests.length; i++) {
            for (Test test : listTests) {
                if (test.getId() == listIdTests[i]) {
                    masNameTests.add(test.getName());
                    masCountQuestion.add(test.getCountQuestion());
                }
            }
        }
    }

    public ArrayList<String> getMasNameTests() {
        return masNameTests;
    }

    public ArrayList<Integer> getMasCountQuestion() {
        return masCountQuestion;
    }
}
