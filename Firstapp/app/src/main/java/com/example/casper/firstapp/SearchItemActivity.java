package com.example.casper.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import cz.mendelu.busItWeek.library.CodeTask;
import cz.mendelu.busItWeek.library.StoryLine;
import cz.mendelu.busItWeek.library.Task;
import cz.mendelu.busItWeek.library.qrcode.QRCodeUtil;

public class SearchItemActivity extends AppCompatActivity {

    private Task currentTask;
    private StoryLine storyLine;
    private FloatingActionButton qrButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        storyLine = StoryLine.open(this, MyDemoStoryLineDBHelper.class);
        qrButton = findViewById(R.id.qr_code_button);
    }

    public void handleQRButtonClick(View view) {
        QRCodeUtil.startQRScan(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        currentTask = storyLine.currentTask();
        if (currentTask != null && currentTask instanceof CodeTask) {
            String result = QRCodeUtil.onScanResult(this, requestCode, resultCode, data);
            CodeTask codeTask = (CodeTask) currentTask;
            if (codeTask.getQR().equals(result)) {
                Toast.makeText(this, result, Toast.LENGTH_LONG).show();
            }
        }
    }
}
