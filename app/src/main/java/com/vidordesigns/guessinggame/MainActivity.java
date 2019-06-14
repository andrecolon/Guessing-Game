package com.vidordesigns.guessinggame;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.view.View.*;


public class MainActivity extends AppCompatActivity {
    // Class as a whole - Open variable for all classes
        static final int PERFECT = 42;
        static final int CORRECT = 0;
        static final int OVER = 1;
        static final int UNDER = 2;
        static final int RESET = 3;

// Variables - not sure if that is what java is calling them
        EditText editDemo;
        Button buttonDemo;
        TextView askQuestion, textResult, noteIssues; // I like this Idea
        int guess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Attach my variables to the UI by id
        editDemo    = findViewById(R.id.edit_demo);
        buttonDemo  = findViewById(R.id.button_demo);
        askQuestion = findViewById(R.id.ask_question);
        textResult  = findViewById(R.id.text_result);
        noteIssues  = findViewById(R.id.note_issues);

        buttonDemo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view){

                // get the numerical guess parse number and pass it through guess variable
                guess = Integer.parseInt(askQuestion.getText().toString());
                // Go through argument for chckGss in the integer that was passed in
                int result = checkGuess(guess);

                updateUI(result);

             }
        });
}
    int checkGuess(int guess) {
        //check to see if the number is correct and return the result as an integer value

        if (guess == PERFECT) {
            return CORRECT;
        } else if (guess < PERFECT) {
            return UNDER;
        } else {
            return OVER;
        }
    }

        public static void updateUI(int results) {


            switch (results) {
                case CORRECT:
                    results.setText("The number is " + CORRECT);
                    break;
                case OVER:
                    results.setText("Too high, think the meaning of life");
                    break;
                case UNDER:
                    results.setText("Too low, think of my age when starting this venture");
                    break;
                default:
                    results.setText("what's that numba again?");

            }
        }

    }
}