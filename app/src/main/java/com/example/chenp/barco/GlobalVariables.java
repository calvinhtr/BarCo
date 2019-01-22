package com.example.chenp.barco;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class GlobalVariables extends Application {

    private String barcodeNext = "";

    public String getBarcodeNext() {
        return barcodeNext;
    }

    public void setBarcodeNext(String newBarcodeNext) {
        this.barcodeNext = newBarcodeNext;
    }

}