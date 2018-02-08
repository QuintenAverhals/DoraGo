package com.example.casper.firstapp;

import cz.mendelu.busItWeek.library.SimplePuzzle;
import cz.mendelu.busItWeek.library.StoryLineDatabaseHelper;
import cz.mendelu.busItWeek.library.builder.StoryLineBuilder;

/**
 * Created by Casper on 2/6/2018.
 */

public class MyDemoStoryLineDBHelper extends StoryLineDatabaseHelper {

    public MyDemoStoryLineDBHelper() {
        super(15);
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
        builder.addCodeTask("1")
                .qr("Brno")
                .location(49.209543,16.614235)
                .simplePuzzle()
                .question("Who am I?")
                .answer("1")
                .puzzleDone()
                .taskDone();*/

        // Riddle 1
        // TODO Specify location

        builder.addGPSTask("1")
                .location(49.209543, 16.614235)
                .radius(50000)
                .choicePuzzle()
                .question("What's furry, swings from tree to tree and goes ooh-ooh ahh-ahh?")
                .hint("Think about Boots")
                .addChoice("Dog", false)
                .addChoice("Monkey", true)
                .addChoice("Cow", false)
                .puzzleDone()
                .taskDone();
        /*
        // Riddle 2
        // TODO Specify location
        builder.addGPSTask("riddle_2")
                .location(0, 0)
                .radius(50)
                .choicePuzzle()
                .question("What is yellow on the outside, white on the inside and you can peel it?")
                .hint("Boots favourite food")
                .addChoice("Apple", false)
                .addChoice("Lemon", false)
                .addChoice("Banana", true)
                .puzzleDone()
                .taskDone();
                */
    }




}
