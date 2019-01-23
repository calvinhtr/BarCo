package com.example.chenp.barco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import info.androidhive.barcode.BarcodeReader;

public class BarCodeScanner extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {
    private BarcodeReader barcodeReader;
    //String to store barcode
    String myBarcode;
    //String to store spreadsheet name
    String spreadSheetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code_scanner);
        //Activity action bar title
        getSupportActionBar().setTitle("Barcode Scanner");
        Intent intent = getIntent();
        //receive the spreadsheet name intent using key "spreadSheetName"
        spreadSheetName = intent.getStringExtra("spreadSheetName");
        //set barcodeReader to the BarcodeReader fragment
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_fragment);

    }


    @Override
    public void onScanned(Barcode barcode) {
        //Sets the barcode to the raw value of the student card and gets rid of the A's scanned at front and back
        myBarcode = barcode.rawValue.substring(1, barcode.rawValue.length() - 1);
        //if Barcode value is not 0 open the new activity with scanned barcode value
        if (myBarcode != null) {
            final String destination = ((GlobalVariables) this.getApplication()).getBarcodeNext();
            Intent startIntent;
            if (destination == "addStudents") {
                startIntent = new Intent(getApplicationContext(), AddItemToSheet.class);
                startIntent.putExtra("spreadSheetName", spreadSheetName);
                spreadSheetName = startIntent.getStringExtra("spreadSheetName");
            } else if (destination == "deleteStudents") {
                startIntent = new Intent(getApplicationContext(), DeleteItemOnSheet.class);
                startIntent.putExtra("spreadSheetName", spreadSheetName);
                spreadSheetName = startIntent.getStringExtra("spreadSheetName");
            } else {
                startIntent = new Intent(getApplicationContext(), CheckStudentOnSheet.class);
                startIntent.putExtra("spreadSheetName", spreadSheetName);
                spreadSheetName = startIntent.getStringExtra("spreadSheetName");
            }
            //Intent that passes barcode to new class
            startIntent.putExtra("password", myBarcode);
            startActivity(startIntent);
            finish();
        }
    }

    @Override
    public void onScannedMultiple(List<Barcode> list) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String s) {

    }

    @Override
    public void onCameraPermissionDenied() {
        Toast.makeText(getApplicationContext(), "Camera permission denied!", Toast.LENGTH_LONG).show();
    }
}