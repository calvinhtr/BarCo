package com.example.chenp.barco;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ExistingSheets extends AppCompatActivity {
    Bundle b = this.getIntent().getExtras();
    String[] array = b.getStringArray("key");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_sheets);
        /*for(int i=0;i<array.length;i++) {
            //Create constraint layout object
            ConstraintLayout myContainer = findViewById(R.id.constraintLayout);
            //Create a constraint layout parameters object
            ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    ConstraintLayout.LayoutParams.FILL_PARENT);
            //dynamically create a new button
            Button btn= new Button( this);
            btn.setId(i);
            final int id_ = btn.getId();

            myContainer.addView(btn,lp);
            btn = ((Button) findViewById(id_));
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent startIntent = new Intent(getApplicationContext(),EditSheet.class);
                    startActivity(startIntent);
        }
        });
            if(array[i]!=null) {
                btn.setText(array[i]);
            }
            else{
                myContainer.removeView(btn);
            }
    }*/
    }
}