package com.example.kishan.homework1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    TextView text,output;
    DisplayMetrics displayMetrics;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text= (TextView) findViewById(R.id.nameText);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText);
        output = (TextView) findViewById(R.id.outputText);

        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                text.setX(rand.nextInt(displayMetrics.widthPixels));
                text.setY(rand.nextInt(displayMetrics.heightPixels));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                ArrayList<String> tempList = new ArrayList<String>();
                String inputString = editText.getText().toString();
                for(int i=0;i<inputString.length();i++){
                    tempList.add(( inputString.substring(i,i+1)));
                }
                String outputString="";
                for(int i = 0;i<inputString.length();i++){
                    //int nextInt=rand.nextInt(inputString.length()-i);
                    outputString+=(tempList.remove(rand.nextInt(inputString.length()-i)));

                }

                output.setText(outputString);
                //output.setText(outputString);

            }
        });


    }
}
