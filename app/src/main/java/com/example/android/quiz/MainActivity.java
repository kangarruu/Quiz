package com.example.android.quiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /* This method accesses the custom font from an asset file. Font was downloaded from the following site and is free for personal use:
     * http://allfreefont.com/fonts/13629/game_of_thrones.php
     * I learned how to set custom fonts from the following source: https://stackoverflow.com/questions/27588965/how-to-use-custom-font-in-android-studio
     */
        TextView introTextView = (TextView) findViewById(R.id.motto_textview);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/Game of Thrones.ttf");
        introTextView.setTypeface(myCustomFont);
    }


    // This method is called when the user presses the Enter button
    public void beginQuiz (View view) {
        Intent openQuiz = new Intent(this, QuizQuestions.class);
        startActivity(openQuiz);
    }

}
