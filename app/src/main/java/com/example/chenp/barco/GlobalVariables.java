package com.example.chenp.barco;

import android.app.Application;

public class GlobalVariables extends Application {
    private String sheetName = "Event 1";
    String spreadSheetNames[] = new String[100];

    public String getSheetNameGlobal(int id) {
        return spreadSheetNames[id];
    }

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