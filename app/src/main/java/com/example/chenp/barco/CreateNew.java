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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //EditText button
        final  EditText editText=(EditText)findViewById(R.id.editText);
        final Toast toast = Toast.makeText(getApplicationContext(),
                "Invalid number of spreadsheets",
                Toast.LENGTH_SHORT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);
        Button createSheetButton = (Button)findViewById(R.id.createSpreadsheetButton);
        createSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //spreadSheet  names array
                spreadSheetNames[spreadSheetNumber]=editText.getText().toString();
                if(spreadSheetNumber>9){
                    toast.show();
                    spreadSheetNumber--;
                }
                spreadSheetNumber++;
                Bundle b = new Bundle();
                b.putStringArray("key", new String[]{spreadSheetNames[0],spreadSheetNames[1],
                        spreadSheetNames[2],spreadSheetNames[3],spreadSheetNames[4],spreadSheetNames[5],
                        spreadSheetNames[6], spreadSheetNames[7],spreadSheetNames[8],spreadSheetNames[9]});
                Intent i=new Intent(getApplicationContext(),ExistingSheets.class);
                i.putExtras(b);
                //start the EditSheet Intent
              //  Intent startIntent = new Intent(getApplicationContext(),EditSheet.class);
                //startActivity(startIntent);
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
