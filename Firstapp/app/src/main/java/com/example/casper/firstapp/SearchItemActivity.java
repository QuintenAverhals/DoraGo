package com.example.casper.firstapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cz.mendelu.busItWeek.library.CodeTask;
import cz.mendelu.busItWeek.library.SimplePuzzle;
import cz.mendelu.busItWeek.library.StoryLine;
import cz.mendelu.busItWeek.library.Task;
import cz.mendelu.busItWeek.library.qrcode.QRCodeUtil;

public class SearchItemActivity extends AppCompatActivity {

    private Task currentTask;
    private StoryLine storyLine;
    private FloatingActionButton qrButton;
    private TextView title;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        storyLine = StoryLine.open(this, MyDemoStoryLineDBHelper.class);
        qrButton = findViewById(R.id.qr_code_button);

        title = findViewById(R.id.itemTitle);
        image = findViewById(R.id.itemImage);

        SimplePuzzle puzzle = (SimplePuzzle) StoryLine.open(this, MyDemoStoryLineDBHelper.class).currentTask().getPuzzle();
        String itemName = puzzle.getAnswer();

        title.setText("Find the " + itemName);

        int id = getResources().getIdentifier(itemName, "drawable", getPackageName());
        image.setImageResource(id);
    }

    public void handleQRButtonClick(View view) {
        QRCodeUtil.startQRScan(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String result = QRCodeUtil.onScanResult(this, requestCode, resultCode, data);
        currentTask = storyLine.currentTask();
        SimplePuzzle puz = (SimplePuzzle) currentTask.getPuzzle();

        if (result != null && result.length() > 0 && result.equals(puz.getAnswer())){
            currentTask.finish(true);
            finish();
        }
    }
}
