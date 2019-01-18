package com.example.chenp.barco;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditSheet extends AppCompatActivity implements View.OnClickListener {
    Button addStudentsButton;
    Button deleteStudentsButton;
    Button displayStudentsButton;
    Button checkStudentsButton;
    Button backEditSpreadsheetButton;
    String spreadSheetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sheet);
        getSupportActionBar().setTitle("Edit Sheet");
        Intent intent = getIntent();
        spreadSheetName = intent.getStringExtra("spreadSheetName");
        addStudentsButton = (Button) findViewById(R.id.addStudentsButton);
        addStudentsButton.setOnClickListener(this);

        checkStudentsButton = (Button) findViewById(R.id.checkStudentButton);
        checkStudentsButton.setOnClickListener(this);

        deleteStudentsButton = (Button) findViewById(R.id.deleteStudentsButton);
        deleteStudentsButton.setOnClickListener(this);

        displayStudentsButton = (Button) findViewById(R.id.displayStudentsButton);
        displayStudentsButton.setOnClickListener(this);

        backEditSpreadsheetButton = (Button) findViewById(R.id.backEditSpreadsheetButton);
        backEditSpreadsheetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // If the 'addItemButton' is clicked, it will call the addItemToSheet() function.
        if (v == addStudentsButton) {
            Intent startIntent = new Intent(getApplicationContext(), BarCodeScanner.class);
            startIntent.putExtra("spreadSheetName", (spreadSheetName));
            startActivity(startIntent);
            ((GlobalVariables) this.getApplication()).setBarcodeNext("addStudents");
            startActivity(startIntent);
        } else if (v == checkStudentsButton) {
            Intent startIntent = new Intent(getApplicationContext(), BarCodeScanner.class);
            startIntent.putExtra("spreadSheetName", (spreadSheetName));
            ((GlobalVariables) this.getApplication()).setBarcodeNext("checkStudents");
            startActivity(startIntent);
        } else if (v == deleteStudentsButton) {
            Intent startIntent = new Intent(getApplicationContext(), BarCodeScanner.class);
            startIntent.putExtra("spreadSheetName", (spreadSheetName));
            ((GlobalVariables) this.getApplication()).setBarcodeNext("deleteStudents");
            startActivity(startIntent);
        } else if (v == displayStudentsButton) {

        } else if (v == backEditSpreadsheetButton) {
            Intent startIntent = new Intent(getApplicationContext(), MainScreen.class);
            startActivity(startIntent);
        }
    }
}
