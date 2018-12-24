package com.example.chenp.barco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExistingSpreadsheets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_spreadsheets);

        Button openSpreadsheet1Button = (Button)findViewById(R.id.openSpreadsheet1Button);
        openSpreadsheet1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),EditSpreadsheet.class);
                startActivity(startIntent);
            }
        });

        Button openSpreadsheet2Button = (Button)findViewById(R.id.openSpreadsheet2Button);
        openSpreadsheet1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),EditSpreadsheet.class);
                startActivity(startIntent);
            }
        });
        Button openSpreadsheet3Button = (Button)findViewById(R.id.openSpreadsheet3Button);
        openSpreadsheet1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),EditSpreadsheet.class);
                startActivity(startIntent);
            }
        });
        Button openSpreadsheet4Button = (Button)findViewById(R.id.openSpreadsheet4Button);
        openSpreadsheet1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),EditSpreadsheet.class);
                startActivity(startIntent);
            }
        });
        Button backExistingSpreadsheetsButton = (Button)findViewById(R.id.backExistingSpreadsheetsButton);
        backExistingSpreadsheetsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),MainScreen.class);
                startActivity(startIntent);
            }
        });

    }
}
