package com.example.chenp.barco;
import android.app.Application;

public class GlobalVariables extends Application {
    private String sheetName = "Event 1";
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

    // Code for storing the next activity for the barcode scanner to go to
    private String barcodeNext = "";

    public String getBarcodeNext(){
        return barcodeNext;
    }

    public void setBarcodeNext(String newBarcodeNext){
        this.barcodeNext = newBarcodeNext;
    }

}
