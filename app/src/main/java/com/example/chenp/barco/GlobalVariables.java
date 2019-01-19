package com.example.chenp.barco;

import android.app.Application;
//Global variables class, used to store variables globally instead of using intents//
public class GlobalVariables extends Application {
    //default sheetName, used for testing purposes
    private String sheetName = "Event 1";
    //array that will store spreadsheet names, maximum of 100
    String spreadSheetNames[] = new String[100];
    // this takes in the id of spreadSheetName button and stores it into the array
    public String getSheetNameGlobal(int id) {
        return spreadSheetNames[id];
    }
    //counter used to keep track of the spreadSheet number
    static int counter = 0;
    private String barcodeNext = "";
    public String getBarcodeNext() {
        return barcodeNext;
    }

    public void setBarcodeNext(String newBarcodeNext) {
        this.barcodeNext = newBarcodeNext;
    }

    public void inputInSpreadSheet(String name) {
        spreadSheetNames[counter] = name;
        counter++;
    }
}