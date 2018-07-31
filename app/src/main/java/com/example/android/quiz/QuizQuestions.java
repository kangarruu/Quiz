package com.example.android.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuizQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);
    }

    public void submitAnswers(View view) {
        // User's score
        int score = 0;

        // Create String to display when wrong answer is selected. This will be updated below and added to toast.
        String wrongAnswer = "For shame!\n";


        // Identify correct answers via findViewById.
        RadioButton answer1 = (RadioButton) findViewById(R.id.q1_rains);
        CheckBox answer2b = (CheckBox) findViewById(R.id.q2_dragonglass);
        CheckBox answer2c = (CheckBox) findViewById(R.id.q2_valyrian);
        RadioButton answer4 = (RadioButton) findViewById(R.id.q4_mockingbird);

        // Identify checkBox answers that should not be checked via findViewById.
        CheckBox answer2a = (CheckBox) findViewById(R.id.q2_fire);
        CheckBox answer2d = (CheckBox) findViewById(R.id.q2_beheading);

        // Identify the the user's EditText input. Set the answer as a lowercase String to check the value
        EditText answer3 = (EditText) findViewById(R.id.q3_bastards);
        String answer3String = answer3.getText().toString().toLowerCase();



        /* If the correct answer is checked add 1 to variable score.
         * If the checked answer is false, update wrongAnswer to be include the question # in toast message*/

        //Method to check if question 1 was answered correctly. If not, update wrongAnswer.
        if (answer1.isChecked()) {
            score++;
        } else {
            wrongAnswer += "Try question 1 again.\n";

        }

        //Method to check if question 2 was answered correctly. If not, update wrongAnswer.
        if (answer2b.isChecked() && answer2c.isChecked() && !(answer2a.isChecked()) && !(answer2d.isChecked())) {
            score++;
        } else {
            wrongAnswer += "Try question 2 again.\n";
        }

        //Method to check if question 3 was answered correctly. If not, update wrongAnswer.
        if (answer3String.contentEquals("battle of the bastards")||answer3String.contentEquals("the battle of the bastards")
                || answer3String.contentEquals("battle of bastards")) {
            score++;
        } else {
            wrongAnswer += "Try question 3 again.\n";
        }

        //Method to check if question 4 was answered correctly. If not, update wrongAnswer.
        if (answer4.isChecked()) {
            score++;
        } else {
            wrongAnswer += "Try question 4 again.\n";
        }

        /* Display Toast once submit button is clicked. If all questions are correct, display "You win. The throne is yours!"
         * If any questions are wrong, display wrongAnswer*/
        if (score == 4) {
            Toast.makeText(QuizQuestions.this, "You win. The throne is yours!", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, wrongAnswer, Toast.LENGTH_LONG).show();
        }
    }
}