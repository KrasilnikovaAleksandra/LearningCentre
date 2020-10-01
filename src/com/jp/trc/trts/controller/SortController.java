package com.jp.trc.trts.controller;

import java.util.ArrayList;

public class SortController {

    private ArrayList<String> listStudentsAndRatings;
    private ArrayList<String> listSortedStudentsAndRatings;

    public SortController() {
        listStudentsAndRatings = new ArrayList<>();
        listSortedStudentsAndRatings = new ArrayList<>();
    }

    public ArrayList<String> getListStudentsAndRatings() {
        return listStudentsAndRatings;
    }

    public void setListStudentsAndRatings(ArrayList<String> listStudentsAndRatings) {
        this.listStudentsAndRatings = listStudentsAndRatings;
    }

    public ArrayList<String> sortStudent() {
        int[] masRatings = new int[listStudentsAndRatings.size()];
        String[] masName = new String[listStudentsAndRatings.size()];
        String[] masSecondName = new String[listStudentsAndRatings.size()];
        for (int i = 0; i < listStudentsAndRatings.size(); i++) {
            String[] parseString = listStudentsAndRatings.get(i).split(" ");
            masName[i] = parseString[0];
            masSecondName[i] = parseString[1];
            masRatings[i] = Integer.parseInt(parseString[2]);
        }
        sortRating(masRatings);

    }

    private  int[] sortRating( int[] masRatings) {
        int v = 0;
        for (int i = 0; i < masRatings.length - 1; i++) {
            if (masRatings[i] > masRatings[i+1]){
                v = masRatings[i];
                masRatings[i] = masRatings[i+1];
                masRatings[i+1] = v;
            }
        }
        return  masRatings;
    }

    private String createSortedList(int[] masRatings, String[] masName,  String[] masSecondName){


    }

}
