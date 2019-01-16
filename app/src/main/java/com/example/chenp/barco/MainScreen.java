package com.example.chenp.barco;
import android.app.Application;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button existingSheetButton = (Button)findViewById(R.id.existingSheetButton);
        existingSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),ExistingSheets.class);
                Bundle b = new Bundle();
                b.putStringArray("key", new String[]{"0","0","0","0","0","0","0","0","0","0"});
                startIntent.putExtras(b);
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
        // Take this button code out after moving add item to after camera detects student card
        Button testButton = (Button)findViewById(R.id.testButton);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),AddItemToSheet.class);
            }
        });
        String sheetName = ((GlobalVariables) this.getApplication()).getSheetNameGlobal();
    }
}
