package com.example.chenp.barco;
import android.app.Application;

public class GlobalVariables extends Application {
    private String sheetName = "";
    String spreadSheetNames[]=new String[100];
    public String getSheetNameGlobal(int id){
        return spreadSheetNames[id];
    }
    static int counter=0;
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

    public void inputInSpreadSheet(String name ){
            spreadSheetNames[counter] = name;
            counter++;
        }
}