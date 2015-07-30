package com.example.ajl.alphabet;
/**
 * @author Anthony Lucchi
 * @version 19.255555
 *
 *
 * This class contains the logic for alphabet, calls the gridview and reloads it when necessary.
 * Takes user input and returns a new view
 *
 * @since       11/01/13 I begin the add a grid view
 * @since       11/03/13 Start invalidating the grid view and restarting to change view
 * @since       11/05/13 I added the function to change a tile a blank
 * @since	   11/07/13 Changed feature to be able to reload original view on back
 * @since	   11/09/13 Alphabet changes views now based on correct letters.
 * @since	   11/15/13 Got the timer to work and display the user's current BAC level.
 */

import java.util.Arrays;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;


//This is where all of the logic goes on
public class MainActivity extends Activity {

    @Override
    public void onPause() {
        // On pause we must revert the blank tiles to their original letters
        imgArray[0] = R.drawable.alpha_a;
        imgArray[1] = R.drawable.alpha_b;
        imgArray[2] = R.drawable.alpha_c;
        imgArray[3] = R.drawable.alpha_d;
        imgArray[4] = R.drawable.alpha_e;
        imgArray[5] = R.drawable.alpha_f;
        imgArray[6] = R.drawable.alpha_g;
        imgArray[7] = R.drawable.alpha_h;
        imgArray[8] = R.drawable.alpha_i;
        imgArray[9] = R.drawable.alpha_j;
        imgArray[10] = R.drawable.alpha_k;
        imgArray[11] = R.drawable.alpha_l;
        imgArray[12] = R.drawable.alpha_m;
        imgArray[13] = R.drawable.alpha_n;
        imgArray[14] = R.drawable.alpha_o;
        imgArray[15] = R.drawable.alpha_p;
        imgArray[16] = R.drawable.alpha_q;
        imgArray[17] = R.drawable.alpha_r;
        imgArray[18] = R.drawable.alpha_s;
        imgArray[19] = R.drawable.alpha_t;
        imgArray[20] = R.drawable.alpha_u;
        imgArray[21] = R.drawable.alpha_v;
        imgArray[22] = R.drawable.alpha_w;
        imgArray[23] = R.drawable.alpha_x;
        imgArray[24] = R.drawable.alpha_y;
        imgArray[25] = R.drawable.alpha_z;

        super.onPause();
    }

    @Override
    public void onResume() {

        adpt.notifyDataSetChanged();
        gridview.invalidateViews();

        super.onResume();
    }

    // Create an integer array that will display the grid view images from these
    // files
    public static Integer[] imgArray = {

            R.drawable.alpha_a, R.drawable.alpha_b, R.drawable.alpha_c,
            R.drawable.alpha_d, R.drawable.alpha_e, R.drawable.alpha_f,
            R.drawable.alpha_g, R.drawable.alpha_h, R.drawable.alpha_i,
            R.drawable.alpha_j, R.drawable.alpha_k, R.drawable.alpha_l,
            R.drawable.alpha_m, R.drawable.alpha_n, R.drawable.alpha_o,
            R.drawable.alpha_p, R.drawable.alpha_q, R.drawable.alpha_r,
            R.drawable.alpha_s, R.drawable.alpha_t, R.drawable.alpha_u,
            R.drawable.alpha_v, R.drawable.alpha_w, R.drawable.alpha_x,
            R.drawable.alpha_y, R.drawable.alpha_z };

    // Takes an Integer and changes it to a blank tile
    private Integer makeBlank(Integer image) {
        double blank = Math.random();

        if (blank < .17)
            return R.drawable.alpha_blank1;
        if (blank < .33)
            return R.drawable.alpha_blank2;
        if (blank < .5)
            return R.drawable.alpha_blank3;
        if (blank < .67)
            return R.drawable.alpha_blank4;
        if (blank < .83)
            return R.drawable.alpha_blank5;

        return R.drawable.alpha_blank6;
    }

    // This is the string for the letters currently found
    private String foundString(int currentLet) {

        switch (currentLet) {

            case 0:
                return "Letters found: A";
            case 1:
                return "Letters found: A B";
            case 2:
                return "Letters found: A B C";
            case 3:
                return "Letters found: A B C D";
            case 4:
                return "Letters found: A B C D E";
            case 5:
                return "Letters found: A B C D E F";
            case 6:
                return "Letters found: A B C D E F G";
            case 7:
                return "Letters found: A B C D E F G H";
            case 8:
                return "Letters found: A B C D E F G H I";
            case 9:
                return "Letters found: A B C D E F G H I J";
            case 10:
                return "Letters found: A B C D E F G H I J K";
            case 11:
                return "Letters found: A B C D E F G H I J K L";
            case 12:
                return "Letters found: A B C D E F G H I J K L M";
            case 13:
                return "Letters found: A B C D E F G H I J K L M N";
            case 14:
                return "Letters found: A B C D E F G H I J K L M N O";
            case 15:
                return "Letters found: A B C D E F G H I J K L M N O P";
            case 16:
                return "Letters found: A B C D E F G H I J K L M N O P Q";
            case 17:
                return "Letters found: A B C D E F G H I J K L M N O P Q R";
            case 18:
                return "Letters found: A B C D E F G H I J K L M N O P Q R S";
            case 19:
                return "Letters found: A B C D E F G H I J K L M N O P Q R S T";
            case 20:
                return "Letters found: A B C D E F G H I J K L M N O P Q R S T U";
            case 21:
                return "Letters found: A B C D E F G H I J K L M N O P Q R S T U V";
            case 22:
                return "Letters found: A B C D E F G H I J K L M N O P Q R S T U V W";
            case 23:
                return "Letters found: A B C D E F G H I J K L M N O P Q R S T U V W X";
            case 24:
                return "Letters found: A B C D E F G H I J K L M N O P Q R S T U V W X Y";
            case 25:
                return "Letters found: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
        }

        return "Current Letter Error";
    }

    //Next Letter to be found
    public int currentLet = 0;

    //Randomize alphabet
    public static Integer[] randomizeArray(Integer[] array) {
        Random rgen = new Random(); // Random number generator

        for (int i = 0; i < array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);

            // Store and random location and then swap the information in those location
            Integer temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }


    private GridView gridview;
    private ImageAdapter adpt;
    Integer[] staticArray;

    //Textview changes the text at the bottom
    TextView text;
    Button quitButton;

    // Declaring a new handler to update the timer
    public Handler mHandler = new Handler();
    //The context for minigame scoring
    private Context context;


    float endTime = 0;
    String endTimeString;
    String endString;
    //Refresh every second
    private final int REFRESH_RATE = 10;
    //Declare string for the timer
    updateTimerReference clockTimer = new updateTimerReference();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // This is the copy we compare the values of the images against
        staticArray = Arrays.copyOf(imgArray, imgArray.length);

        // This is what shows up on the screen which is why it must be
        // randomized
        imgArray = randomizeArray(imgArray);

        // We get a start time
        clockTimer.startTime = System.currentTimeMillis();

        // We start the clock
        mHandler.postDelayed(clockTimer, REFRESH_RATE);

        // Save the state
        super.onCreate(savedInstanceState);

        // Creating the content view
        setContentView(R.layout.activity_main);

        // This is where we find out grid view
        gridview = (GridView) findViewById(R.id.gridview);
        // This is where we set out images to display on the grid view, call
        // repeatedly to update grid view
        adpt = new ImageAdapter(this);
        gridview.setAdapter(adpt);

        text = (TextView) findViewById(R.id.correctstring);

        // This is the logic for on click
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // This is an example of switching out a tile for a blank tile
                if (imgArray[position] == staticArray[currentLet]) {

                    //While not finished keep updating text based on time
                    if (!clockTimer.mFinished) {
                        text.setText(foundString(currentLet));
                    }

                    imgArray[position] = makeBlank(imgArray[position]);

                    ++currentLet;
                    adpt.notifyDataSetChanged();
                    gridview.invalidateViews();

                    if (currentLet == 26) {

                        currentLet = 0;
                        // We set m Finished to true
                        clockTimer.mFinished = true;
                        showScore(context);


                    }

                    // If the wrong letter is selected
                } else {

                    // This re-randomizes the images
                    imgArray = randomizeArray(imgArray);
                    // notifies the adapter of data change
                    adpt.notifyDataSetChanged();
                    // This recreates the grid view
                    gridview.invalidateViews();

                }

            }
        });

    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    */

    class updateTimerReference implements Runnable {
        private Object mPauseLock;
        private boolean mPaused;
        private boolean mFinished = false;

        private String hours, minutes, seconds, milliseconds;
        private long secs, mins, hrs;
        private long startTime;

        // public boolean mFinished = false;

        public updateTimerReference() {

            mPauseLock = new Object();
            mPaused = false;

        }

        public void run() {
            //Save the time and the final end time.
            float time = System.currentTimeMillis() - startTime;
            endTime = time;

            secs = (long) (time / 1000);
            mins = (long) ((time / 1000) / 60);
            hrs = (long) (((time / 1000) / 60) / 60);
			/*
			 * Convert the seconds to String * and format to ensure it has * a
			 * leading zero when required
			 */
            secs = secs % 60;
            seconds = String.valueOf(secs);
            if (secs == 0) {
                seconds = "00";
            }
            if (secs < 10 && secs > 0) {
                seconds = "0" + seconds;
            }
			/* Convert the minutes to String and format the String */
            mins = mins % 60;
            minutes = String.valueOf(mins);
            if (mins == 0) {
                minutes = "00";
            }
            if (mins < 10 && mins > 0) {
                minutes = "0" + minutes;
            }
			/* Convert the hours to String and format the String */
            hours = String.valueOf(hrs);
            if (hrs == 0) {
                hours = "00";
            }
            if (hrs < 10 && hrs > 0) {
                hours = "0" + hours;
            }
			/*
			 * Although we are not using milliseconds on the timer in this
			 * example * I included the code in the event that you wanted to
			 * include it on your own
			 */

            milliseconds = String.valueOf((long) time);
            if (milliseconds.length() == 2) {
                milliseconds = "0" + milliseconds;
            }
            if (milliseconds.length() <= 1) {
                milliseconds = "00";
            }
            milliseconds = milliseconds.substring(milliseconds.length() - 3,
                    milliseconds.length() - 2);

            //If statement based off of time to set the text and end string.
            if (secs > 0 && secs < 21 && mins == 0 && hrs == 0) {
                ((TextView) findViewById(R.id.endText))
                        .setText("Wow you're fast!");
                endString = "Wow you're fast!";
            } else if (secs >= 21 && secs < 50 && mins == 0 && hrs == 0) {
                ((TextView) findViewById(R.id.endText))
                        .setText("That's a normal reaction time.");
                endString = "That's a normal reaction time";
            } else if (secs >= 50 && secs < 60 && mins == 0 && hrs == 0) {
                ((TextView) findViewById(R.id.endText))
                        .setText("You're entering the danger zone!");
                endString = "You're entering the danger zone!";
            } else if (mins > 0 && mins < 2) {
                ((TextView) findViewById(R.id.endText))
                        .setText("You are probably impared.");
                endString = "You are probably impared.";
            } else{
                ((TextView) findViewById(R.id.endText))
                        .setText("You are clearly inebriated.");
                endString = "You are clearly inebriated.";
            }
			/* Setting the timer text to the elapsed time */
            ((TextView) findViewById(R.id.timer)).setText(hours + ":" + minutes + ":" + seconds + ":" + milliseconds);
            //setting the endTime String to same thing
            endTimeString = (minutes + ":" + seconds + "." + milliseconds);
            if (!mFinished) {
                mHandler.postDelayed(this, 10);
            }
        }
    }
    /**
     * Displays the {@link MinigameResultsDialog} with the user's score for the
     * game play
     *
     * @param canvas
     *            The Canvas to draw the {@link MinigameResultsDialog}
     */
    public void showScore(Context context) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //MinigameResultsDialog dialog = MinigameResultsDialog.newInstance(
                //(MainActivity) this, ("Your time is " + endTimeString + " " + endString),
                //calculateScore());
        //dialog.show(((MainActivity)  this).getFragmentManager(), "dialog");
    }

    /**
     * Returns the calculated final score for the game
     *
     * @return Returns an integer score greater or equal to zero for the user's
     *         game play
     */
    private int calculateScore() {
        if(endTime / 12000 > 35){
            return 35;
        }
        return (int)(endTime / 12000);
    }
}
