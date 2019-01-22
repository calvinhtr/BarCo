package com.example.chenp.barco;

import android.app.Application;

public class GlobalVariables extends Application {

    private String barcodeNext = "";

    public String getBarcodeNext() {
        return barcodeNext;
    }

    public void setBarcodeNext(String newBarcodeNext) {
        this.barcodeNext = newBarcodeNext;
    }

}