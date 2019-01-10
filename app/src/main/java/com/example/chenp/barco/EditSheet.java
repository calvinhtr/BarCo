package com.example.chenp.barco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditSheet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sheet);

        Button addStudentsButton = (Button)findViewById(R.id.addStudentsButton);
        addStudentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for opening camera to scan student card barcode; returns a student number
                Intent startIntent = new Intent(getApplicationContext(),BarCodeScanner.class);
                startActivity(startIntent);
            }
        });
        Button checkStudentButton = (Button)findViewById(R.id.checkStudentButton);
        checkStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for opening camera to scan student card barcode; returns a student number
                Intent startIntent = new Intent(getApplicationContext(),BarCodeScanner.class);
                startActivity(startIntent);
            }
        });
        Button displayStudentsButton = (Button)findViewById(R.id.displayStudentsButton);
        displayStudentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code for opening spreadsheet to display students that are registered
            }
        });

        Button backEditSpreadsheetButton = (Button)findViewById(R.id.backEditSpreadsheetButton);
        backEditSpreadsheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),MainScreen.class);
                startActivity(startIntent);
            }
        });
    }
}
