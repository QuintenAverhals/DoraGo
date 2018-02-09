package com.example.casper.firstapp;

import cz.mendelu.busItWeek.library.SimplePuzzle;
import cz.mendelu.busItWeek.library.StoryLineDatabaseHelper;
import cz.mendelu.busItWeek.library.builder.StoryLineBuilder;

/**
 * Created by Casper on 2/6/2018.
 */

public class MyDemoStoryLineDBHelper extends StoryLineDatabaseHelper {

    public MyDemoStoryLineDBHelper() {
        super(51);
    }

    @Override
    protected void onCreate(StoryLineBuilder builder) {
        /*builder.addGPSTask("1")
                .radius(1000)
                .location(49.209543, 16.614235)
                .victoryPoints(5)
                .simplePuzzle()
                .question("What is the answer to life and everything?")
                .answer("42")
                .hint("hitchhikers guide to the galaxy")
                .puzzleTime(30000)
                .puzzleDone()
                .taskDone();
        builder.addBeaconTask("2")
                .location(49.210451, 16.614749)
                .beacon(5635,2481)
                .choicePuzzle()
                .question("What is the best city in the world?")
                .addChoice("Brussels",false)
                .addChoice("Brno",true)
                .addChoice("Paris",false)
                .addChoice("London",false)
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("1")
                .location(49.209543,16.614235)
                .radius(500000)
                .imageSelectPuzzle()
                .addImage(R.drawable.image_1, false)
                .addImage(R.drawable.image_2, true)
                .addImage(R.drawable.image_3, false)
                .addImage(R.drawable.image_4, false)
                .question("Select image?")
                .puzzleDone()
                .taskDone();
                */

        builder.addGPSTask("riddle_1")
                .location(49.214179, 16.622868)
                .radius(500)
                .choicePuzzle()
                .question("What's furry, swings from tree to tree and goes ooh-ooh ahh-ahh?")
                .hint("Think about Boots")
                .addChoice("Dog", false)
                .addChoice("Monkey", true)
                .addChoice("Cow", false)
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("riddle_2")
                .location(49.213653,16.620948)
                .radius(500)
                .choicePuzzle()
                .question("I need to find the big city, can you help me?")
                .addChoice("city", true)
                .addChoice("bridge", false)
                .addChoice("boat", false)
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("riddle_3")
                .location(49.214868,16.6290987)
                .radius(500)
                .choicePuzzle()
                .question("What is the name of the sneaky fox?")
                .addChoice("carter", false)
                .addChoice("benny", false)
                .addChoice("swiper", true)
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("qrcode_1")
                .location(49.214768, 16.625078)
                .radius(500)
                .simplePuzzle()
                .question("qrcode")
                .answer("ball")
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("qrcode_1")
                .location(49.212735, 16.617279)
                .radius(500)
                .simplePuzzle()
                .question("qrcode")
                .answer("guitar")
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("swiper_1")
                .location(49.210016, 16.614779)
                .radius(5000)
                .simplePuzzle()
                .question("swiper")
                .answer("swiper no swiping")
                .puzzleDone()
                .taskDone();
    }




}
