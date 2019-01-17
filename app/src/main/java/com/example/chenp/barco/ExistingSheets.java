package com.example.chenp.barco;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.chenp.barco.GlobalVariables.counter;

public class ExistingSheets extends AppCompatActivity {
    int numberOfSheets = ((GlobalVariables) this.getApplication()).counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_sheets);
        Button back=(Button)findViewById(R.id.backExistingSheetsButton);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), MainScreen.class);
                startActivity(startIntent);
            }});
        String[] array = new String[counter];

        for (int i = 0; i < array.length; i++) {
            array[i] = ((GlobalVariables) this.getApplication()).spreadSheetNames[i];
        }
        for (int i = 0; i < counter; i++) {
            //Create constraint layout object
            System.out.println(array[i]);
            ConstraintLayout myContainer = findViewById(R.id.constraintLayout);
            //Create a constraint layout parameters object
            Button btn = new Button(this);
            btn.setId(i);
            btn.setText(array[i]);
            //sheetName is updated with the array sheet name
            ((GlobalVariables) this.getApplication()).setSheetName(array[i]);
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent startIntent = new Intent(getApplicationContext(), EditSheet.class);
                    startActivity(startIntent);
                }
            });
            myContainer.addView(btn);
               ConstraintSet constraintSet= new ConstraintSet();
               constraintSet.clone(myContainer);
            constraintSet.connect(btn.getId(),constraintSet.TOP,myContainer.getId(),constraintSet.TOP,i * 100  + 8);
            constraintSet.connect(btn.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
            constraintSet.connect(btn.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
            constraintSet.connect(btn.getId(),constraintSet.BOTTOM,myContainer.getId(),constraintSet.BOTTOM,(counter - i - 1) * 100
            + 16);
               constraintSet.applyTo(myContainer);
            findViewById(R.id.constraintLayout).invalidate();
            //dynamically create a new button


        }
    }
}