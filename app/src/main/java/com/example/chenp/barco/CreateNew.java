package com.example.chenp.barco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNew extends AppCompatActivity {
//array that will store all the spreadsheet names
String spreadSheetNames[]=new String[10];
//Counter to keep track of the number of spreadsheets
int spreadSheetNumber=0;
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //EditText button

        final Toast toast = Toast.makeText(getApplicationContext(),
                "Invalid number of spreadsheets",
                Toast.LENGTH_SHORT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        Button createSheetButton = (Button)findViewById(R.id.createSpreadsheetButton);
        createSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText=(EditText)findViewById(R.id.editText);
                //spreadSheet  names array
                spreadSheetNames[spreadSheetNumber]=editText.getText().toString();
                if(spreadSheetNumber>9){
                    toast.show();
                    spreadSheetNumber--;
                }
                spreadSheetNumber++;
                // addToSpreadsheets
                Intent i=new Intent(getApplicationContext(),ExistingSheets.class);;
                //start the EditSheet Intent
                startActivity(i);
            }
        });

        Button backCreateNewButton = (Button)findViewById(R.id.backCreateNewButton);
        backCreateNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),MainScreen.class);
                startActivity(startIntent);
            }
        });
    }
}
