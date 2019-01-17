package com.example.chenp.barco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNew extends AppCompatActivity implements View.OnClickListener{
//array that will store all the spreadsheet names
String spreadSheetNames[]=new String[10];
//Counter to keep track of the number of spreadsheets
int spreadSheetNumber=0;
EditText editText;
String temp;
Button createSheetButton;
Button backCreateNewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Toast toast = Toast.makeText(getApplicationContext(),
                "Invalid number of spreadsheets",
                Toast.LENGTH_SHORT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        createSheetButton = (Button)findViewById(R.id.createSpreadsheetButton);
        createSheetButton.setOnClickListener(this);
        backCreateNewButton = (Button)findViewById(R.id.backCreateNewButton);
        backCreateNewButton.setOnClickListener(this);
    }
    public void onClick(View v) {
        // If the 'addItemButton' is clicked, it will call the addItemToSheet() function.
        if (v == createSheetButton){
            editText=(EditText)findViewById(R.id.editText);
            //spreadSheet  names array
            ((GlobalVariables) this.getApplication()).inputInSpreadSheet(editText.getText().toString());
            // addToSpreadsheets
            Intent i=new Intent(getApplicationContext(),ExistingSheets.class);;
            //start the EditSheet Intent
            startActivity(i);
        }
        else if (v == backCreateNewButton){
            Intent startIntent = new Intent(getApplicationContext(),MainScreen.class);
            startActivity(startIntent);
        }
    }
}


