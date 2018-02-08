package com.example.casper.firstapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SwiperActivity extends AppCompatActivity implements AudioMeter.MicLevelReaderValueListener {

    private AudioMeter audioMeter;
    private Thread mRecorderThread;

    private ProgressBar progressBar;
    private boolean hasUserShouted;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiper);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = findViewById(R.id.progressBar);

        audioMeter = new AudioMeter(this, LevelMethod.dBFS);
        mRecorderThread = new Thread(audioMeter);

        mHandler = new Handler(Looper.getMainLooper());

        hasUserShouted = false;
        checkMicrophoneAccess();
    }

    private void checkMicrophoneAccess() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.RECORD_AUDIO},
                    REQUEST_RECORD_AUDIO);
        }else{
            mRecorderThread.start();
        }
    }

    private static final int REQUEST_RECORD_AUDIO = 121;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_RECORD_AUDIO: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mRecorderThread.start();
                } else {
                    Toast.makeText(this, "microphone dead", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private void userShouted(){
        hasUserShouted = true;
        mHandler.postDelayed(
                new Runnable() {
                    public void run() {
                        Intent intent = new Intent(SwiperActivity.this, FinishActivity.class);
                        startActivity(intent);
                    }
                },
                2000);
    }


    @Override
    public void valueCalculated(double level) {
        progressBar.setProgress(50 + (int) level);
        if(level > -3 && !hasUserShouted) {
            userShouted();
        }
    }

    public void stopRecording() {
        try {
            if (audioMeter.isRunning()) {
                audioMeter.stop();
                mRecorderThread.join();
            }
        } catch (Exception e) {
            Log.i("tag", e.getMessage());
        }
    }

    @Override
    protected void onStop() {
        stopRecording();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        stopRecording();
        super.onDestroy();
    }

}
