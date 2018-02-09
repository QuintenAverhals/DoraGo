package com.example.casper.firstapp;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by quint on 08/02/2018.
 */

public class Music {
    public static MediaPlayer themeSong = null;
    private static MediaPlayer positiveCheer = null;

    public static void doThemeSong(Context context) {
        if (themeSong == null) {
            themeSong = MediaPlayer.create(context, R.raw.dora_theme_song);
        }
        else if (themeSong.isPlaying()){
            themeSong.pause();
            themeSong.seekTo(0);
        }
        else {
            themeSong.start();
        }
    }

    public static void doPositiveCheer(Context context) {
        if (positiveCheer == null) {
            positiveCheer = MediaPlayer.create(context, R.raw.cheer_positive);
            positiveCheer.start();
        }
        else if (positiveCheer.isPlaying()){
            positiveCheer.pause();
            positiveCheer.seekTo(0);
        }
        else {
            positiveCheer.start();
        }
    }
}
