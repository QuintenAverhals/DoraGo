package com.example.casper.firstapp;

import cz.mendelu.busItWeek.library.SimplePuzzle;
import cz.mendelu.busItWeek.library.StoryLineDatabaseHelper;
import cz.mendelu.busItWeek.library.builder.StoryLineBuilder;

/**
 * Created by Casper on 2/6/2018.
 */

public class MyDemoStoryLineDBHelper extends StoryLineDatabaseHelper {

    public MyDemoStoryLineDBHelper() {
        super(60);
    }

    @Override
    protected void onCreate(StoryLineBuilder builder) {
        builder.addGPSTask("riddle_1")
                .location(49.214179, 16.622868)
                .radius(10)
                .choicePuzzle()
                .question("What's furry, swings from tree to tree and goes ooh-ooh ahh-ahh?")
                .hint("Think about Boots")
                .addChoice("Dog", false)
                .addChoice("Monkey", true)
                .addChoice("Cow", false)
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("riddle_2")
                .location(49.214868,16.6290987)
                .radius(10)
                .choicePuzzle()
                .question("What is the name of the sneaky fox?")
                .addChoice("carter", false)
                .addChoice("benny", false)
                .addChoice("swiper", true)
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("path_1")
                .location(49.213653,16.620948)
                .radius(10)
                .imageSelectPuzzle()
                .addImage(R.drawable.img1_1, false)
                .addImage(R.drawable.img1_2, true)
                .addImage(R.drawable.img1_3, false)
                .question("I need to find the castle, can you help me?")
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("path_2")
                .location(49.213653,16.620948)
                .radius(10)
                .imageSelectPuzzle()
                .addImage(R.drawable.img2_1, false)
                .addImage(R.drawable.img2_2, true)
                .addImage(R.drawable.img2_3, false)
                .question("I need to find the big city, can you help me?")
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("qrcode_1")
                .location(49.214768, 16.625078)
                .radius(10)
                .simplePuzzle()
                .question("qrcode")
                .answer("ball")
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("qrcode_2")
                .location(49.212735, 16.617279)
                .radius(10)
                .simplePuzzle()
                .question("qrcode")
                .answer("guitar")
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("swiper_1")
                .location(49.210016, 16.614779)
                .radius(10)
                .simplePuzzle()
                .question("swiper")
                .answer("swiper no swiping")
                .puzzleDone()
                .taskDone();
    }




}
