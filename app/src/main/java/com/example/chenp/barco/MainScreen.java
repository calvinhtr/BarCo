package com.example.chenp.barco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        //Create existingSheetButton object
        Button existingSheetButton = (Button) findViewById(R.id.existingSheetButton);
        //onClickListener that starts the ExistingSheets activity
        existingSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ExistingSheets.class);
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
