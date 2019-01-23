package com.example.chenp.barco;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditSheet extends AppCompatActivity implements View.OnClickListener {
    //Create button objects
    Button addStudentsButton;
    Button deleteStudentsButton;
    Button displayStudentsButton;
    Button checkStudentsButton;
    String spreadSheetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sheet);
        //Set the action bar of the activity sheet
        getSupportActionBar().setTitle("Edit Sheet");
        //receive the spreadsheet name through with getIntent().getStringExtra()
        Intent intent = getIntent();
        spreadSheetName = intent.getStringExtra("spreadSheetName");
        //set onClickListeners for buttons
        addStudentsButton = (Button) findViewById(R.id.addStudentsButton);
        addStudentsButton.setOnClickListener(this);

        checkStudentsButton = (Button) findViewById(R.id.checkStudentButton);
        checkStudentsButton.setOnClickListener(this);

        deleteStudentsButton = (Button) findViewById(R.id.deleteStudentsButton);
        deleteStudentsButton.setOnClickListener(this);

        displayStudentsButton = (Button) findViewById(R.id.displayStudentsButton);
        displayStudentsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == addStudentsButton) {
            Intent startIntent = new Intent(getApplicationContext(), BarCodeScanner.class);
            // Adds the name of the spreadsheet clicked to the intent
            startIntent.putExtra("spreadSheetName", (spreadSheetName));
            // Writes to the global variable that stores the destination after the barcode is scanned
            ((GlobalVariables) this.getApplication()).setBarcodeNext("addStudents");
            startActivity(startIntent);
        }
        else if (v == checkStudentsButton) {
            Intent startIntent = new Intent(getApplicationContext(), BarCodeScanner.class);
            startIntent.putExtra("spreadSheetName", (spreadSheetName));
            ((GlobalVariables) this.getApplication()).setBarcodeNext("checkStudents");
            startActivity(startIntent);
        }
        else if (v == deleteStudentsButton) {
            Intent startIntent = new Intent(getApplicationContext(), BarCodeScanner.class);
            startIntent.putExtra("spreadSheetName", (spreadSheetName));
            ((GlobalVariables) this.getApplication()).setBarcodeNext("deleteStudents");
            startActivity(startIntent);
        }
        // If the 'displayStudentsButton' is clicked, open the link to the spreadsheet
        else if (v == displayStudentsButton) {
            Uri uri = Uri.parse("https://docs.google.com/spreadsheets/d/1_2QccSd2XGne3HKNpianwGYZvC6hl9ho4nJhE_kGzp0/edit#gid=0");
            Intent startIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(startIntent);
        }
    }
}
