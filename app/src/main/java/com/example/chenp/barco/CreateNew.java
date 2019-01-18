package com.example.chenp.barco;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CreateNew extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button createSheetButton;
    Button backCreateNewButton;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        getSupportActionBar().setTitle("Create New Spreadsheet");
        createSheetButton = (Button) findViewById(R.id.createSpreadsheetButton);
        createSheetButton.setOnClickListener(this);

        backCreateNewButton = (Button) findViewById(R.id.backCreateNewButton);
        backCreateNewButton.setOnClickListener(this);

        editText = (EditText) findViewById(R.id.editText);
    }

    public void createSheetOnSpreadsheet() {
        final ProgressDialog loading = ProgressDialog.show(this, "Adding spreadsheet", "Please wait");
        final String sheetName = editText.getText().toString().trim();
        // Has URL of web app that has access to the Google Sheets
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbz23ZasmP5RpboMtGCrm5fG47BbXvd_8Laki8O0fOn8iF7WIN0/exec",
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        loading.dismiss();
                        Toast.makeText(CreateNew.this, response, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainScreen.class);
                        startActivity(intent);
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

                //here we pass params
                params.put("action", "createNewSheet");
                params.put("newSheetName", sheetName);

                return params;
            }
        };

        // Create the timeout length and retry if this time has passed
        int socketTimeOut = 5000;

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);
    }

    public void onClick(View v) {
        // If the 'addItemButton' is clicked, it will call the addItemToSheet() function.
        if (v == createSheetButton) {
            createSheetOnSpreadsheet();
            //spreadSheet  names array
            ((GlobalVariables) this.getApplication()).inputInSpreadSheet(editText.getText().toString());
            // addToSpreadsheets
            Intent i = new Intent(getApplicationContext(), ExistingSheets.class);
            ;
            //start the EditSheet Intent
            startActivity(i);
        } else if (v == backCreateNewButton) {
            Intent startIntent = new Intent(getApplicationContext(), MainScreen.class);
            startActivity(startIntent);
        }
    }
}


