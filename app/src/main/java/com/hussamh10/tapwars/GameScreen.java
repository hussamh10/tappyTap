package com.hussamh10.tapwars;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameScreen extends AppCompatActivity {

    private boolean started;
    private boolean timer_started;
    private int aim_time;
    private double user_time;
    private long start;
    private long end;
    private TextView main;
    private TextView difference;
    private TextView help;
    private View main_view;
    private Random rand;

    private static final String[] colors = {
        "#7986CB",
        "#64B5F6",
        "#7E57C2",
        "#03A9F4",
        "#00BCD4",
        "#009688",
        "#1ABC9C",
        "#BDC3C7",
        "#7F8C8D",
        "#95A5A6",
        "#F1C40F",
        "#E57373",
        "#F06292",
        "#E040FB",
        "#9C27B0",
        "#66BB6A",
        "#FFFFFF"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_game_screen);

        rand = new Random();

        int tf = getRand(12);
        String path = "fonts/" + Integer.toString(tf) + ".ttf";

        Typeface typeface = Typeface.createFromAsset(getAssets(), path);

        int i = getRand(17);
        String color = colors[i];



        timer_started = false;
        started = false;

        difference = (TextView) findViewById(R.id.tv_difference);
        main = (TextView) findViewById(R.id.tv_main);
        help = (TextView) findViewById(R.id.tv_help);

        main_view = findViewById(R.id.main);
        main_view.setBackgroundColor(Color.parseColor(color));

        main.setTypeface(typeface);
        difference.setTypeface(typeface);
        help.setTypeface(typeface);
    }

    public int getRand(){
        int  n = rand.nextInt(10) + 1;
        return n;
    }

    public int getRand(int m){
        int  n = rand.nextInt(m);
        return n;
    }

    public boolean onTouchEvent(MotionEvent evt) {
        if (evt.getAction() == MotionEvent.ACTION_DOWN) {
            main_view.setBackgroundColor(Color.parseColor(colors[getRand(15)]));
            if (!this.started){
                this.started = true;
                aim_time = getRand();
                help.setText("");
                main.setText("" + aim_time);
                start = System.nanoTime();
                return true;
            }
            else{
                {
                    end = System.nanoTime();
                    double diff = (end-start)/1000000000.0;
                    user_time = diff - aim_time;
                    String user_time_str = (String) String.format("%.4f", user_time);
                    difference.setText("" + user_time_str);

                    try{
                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }

                    start = System.nanoTime();
                    aim_time = getRand();
                    main.setText("" + aim_time);
                }
            }
        }
        return false;
    }
    private void init(){
        // wait for initial tap
        // go to started
    }

    private void started(){
        while(true){
            // difference = stage(random number);
            // print difference
            // wait 0.1 seconds
        }
    }

    private void stage(){
        //time started
        //wait for tap
    }
}
