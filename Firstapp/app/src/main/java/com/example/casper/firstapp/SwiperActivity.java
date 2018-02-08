package com.example.casper.firstapp;

import android.content.pm.PackageManager;
import android.os.Bundle;
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
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SwiperActivity extends AppCompatActivity implements AudioMeter.MicLevelReaderValueListener {

    private AudioMeter audioMeter;
    private Thread mRecorderThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiper);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        audioMeter = new AudioMeter(this, LevelMethod.dBFS);
        mRecorderThread = new Thread(audioMeter);

        checkMicrophoneAccess();
    }

    private void checkMicrophoneAccess() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.RECORD_AUDIO},
                    REQUEST_RECORD_AUDIO);
        }else{
            start();
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
                    start();
                } else {
                    Toast.makeText(this, "microphone dead", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private void start(){
        Toast.makeText(this, "microphone ready", Toast.LENGTH_SHORT).show();
        mRecorderThread.start();
    }

    @Override
    public void valueCalculated(double level) {
        if(level > -10){
            Log.i("value", level + "");
        }
        if(level > -5) {
            stopit();
        }
    }

    public void stopit() {
        if (audioMeter.isRunning()) {
            audioMeter.stop();
            try {
                mRecorderThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onStop() {
        stopit();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        stopit();

        super.onDestroy();
    }

}
