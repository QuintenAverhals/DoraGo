package com.example.casper.firstapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Music.doThemeSong(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Music.doThemeSong(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Music.doThemeSong(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Music.doThemeSong(this);
    }
}
