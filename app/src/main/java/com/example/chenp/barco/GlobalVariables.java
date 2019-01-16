package com.example.chenp.barco;
import android.app.Application;

public class GlobalVariables extends Application {
    private String sheetName = "asdfadf";
    String spreadSheetNames[]=new String[10];
    public String getSheetNameGlobal(){
        return sheetName;
    }

    public void setSheetName(String newSheetName){
        this.sheetName = newSheetName;
    }

    public void addToSheetNames(String newSheetToAdd){
// add sheet names to this array when you create new; this saves you from passing your array from activity to activity
}
}
