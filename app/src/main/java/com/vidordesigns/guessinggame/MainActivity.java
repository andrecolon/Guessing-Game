package com.vidordesigns.guessinggame;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import static android.view.View.*;


public class MainActivity extends AppCompatActivity {

//    static final int CORRECT = 0;
//    static final int LOW = 1;
//    static final int HIGH = 2;
//    static final int RESET = 3;

        EditText editDemo;
        Button buttonDemo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDemo = findViewById(R.id.edit_demo);
        buttonDemo = findViewById(R.id.button_demo);
        buttonDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String content = String.valueOf(editDemo.getText());
                Log.i("Demo",content);
                //int nuym = content * 6;
                int value = Integer.parseInt(content);
                //nuym = alue *2;


             }
        });
    }
}
