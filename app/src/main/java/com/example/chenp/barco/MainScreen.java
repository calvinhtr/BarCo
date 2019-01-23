package com.example.chenp.barco;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainScreen extends AppCompatActivity {

    public static String[] sheetNames;
    // Function to get the sheet names from the Google Apps Script
    private void retrieveSheets() {

        // Create a loading dialog box
        final ProgressDialog loading = ProgressDialog.show(this, "Retrieving sheets", "Please wait");

        // Has URL of web app that has access to the Google Sheets
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbz23ZasmP5RpboMtGCrm5fG47BbXvd_8Laki8O0fOn8iF7WIN0/exec",
                new com.android.volley.Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        loading.dismiss();
                        // Gets the response, which is a string of names separated by commas and splits it into an array, each element starting at each comma
                        MainScreen.sheetNames = response.split(",");
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                // Sends parameters to Google Apps Script
                params.put("action", "getSheets");

                return params;
            }
        };

        int socketTimeOut = 5000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);
        RequestQueue queue = Volley.newRequestQueue(this);
        // Add stringRequest to the queue
        queue.add(stringRequest);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Must retrieve sheets in advance of entering the ExistingSheets activity (before layout is created)
        retrieveSheets();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        // Create the buttons' functions
        Button existingSheetButton = (Button) findViewById(R.id.existingSheetButton);
        //onClickListener that starts the ExistingSheets activity
        existingSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sends the sheetName array to ExistingSheets activity
                Intent startIntent = new Intent(getApplicationContext(), ExistingSheets.class);
                // Sends the array of sheet names to existing sheets activity
                Bundle b = new Bundle();
                b.putStringArray("sheetNameArray", sheetNames);
                startIntent.putExtras(b);
                startActivity(startIntent);
            }
        });
        //Create creatNewButton object
        Button createNewButton = (Button) findViewById(R.id.createNewButton);
        //onClickListener that starts the CreateNew activity
        createNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), CreateNew.class);
                startActivity(startIntent);
            }
        });
    }
}
