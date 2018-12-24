package com.example.chenp.barco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button existingSpreadsheetButton = (Button)findViewById(R.id.existingSpreadsheetButton);
        existingSpreadsheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),ExistingSpreadsheets.class);
                startActivity(startIntent);
            }
        });
        Button createNewButton = (Button)findViewById(R.id.createNewButton);
        createNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),CreateNew.class);
                startActivity(startIntent);
            }
        });


    }
}
