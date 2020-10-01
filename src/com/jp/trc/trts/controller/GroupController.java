package com.jp.trc.trts.controller;

import com.jp.trc.trts.model.Group;

/**
 * This class is the controller which works with groups of students.
 */
public class GroupController {

    private Group[] listGroups;
    private ControllerWithStaticData staticData;

    /**
     * It is constructor.
     */
    public GroupController() {
        staticData = new ControllerWithStaticData();
        listGroups = staticData.getGroups();
    }

    /**
     * This method returns the list of tests for the a specific group.
     * @param idGroup
     * @return
     */
    public int[] defineListIdTests(int idGroup) {
        int[] listIdTests = new int[0];
        for (Group group : listGroups) {
            if (group.getId() == idGroup) {
                listIdTests = group.getIdTests();
            }
        }
        return listIdTests;
    }

    /**
     * This method defines names of the groups by ID.
     * @param idGroups
     * @return the string of group names.
     */
    public String defineNameGroups(int[] idGroups) {
        int counter = 0;
        String result = "";
        for (Group group : listGroups) {
            for (int id : idGroups) {
                if (id == group.getId()) {
                    result += counter + ") " + group.getName() + "\n";
                    counter++;
                }
            }
        }
        return result;
    }
}
