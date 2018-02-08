package com.example.casper.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QRCodeFinish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_finish);
    }

    public void goToMap(){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
