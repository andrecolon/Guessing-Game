package com.vidordesigns.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    // Class as a whole - Open variable for all classes
        static final int PERFECT = 42;
        static final int CORRECT = 0;
        static final int OVER = 1;
        static final int UNDER = 2;
        //static final int RESET = 3;

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

//                // get the numerical guess parse number and pass it through guess variable
                guess = Integer.parseInt(askQuestion.getText().toString());
//                // Go through argument for check Guess in the integer that was passed in
                int result = checkGuess(guess);
//
                updateUI(result);

             }
        });
    }
    int checkGuess(int guess) {

        if (guess == PERFECT) {
            return CORRECT;
        } else if (guess < PERFECT) {
            return UNDER;
        } else {
            return OVER;
        }
    }

    void updateUI(int result) {
        // this will perform all the tasks necessary to update the display once the result has been determined
        // use a switch statement inside of this method to determine what to display to the user based on the provided result.
        switch (result) {
            case CORRECT:
                textResult.setText("You got it! The number was: " + guess);
                break;
            case UNDER:
                textResult.setText(guess + " is too low.");
                break;
            case OVER:
                textResult.setText(guess +" is too high.");
                break;
            default:
                textResult.setText("Okay, restart it yourself.");
        }
    }
}