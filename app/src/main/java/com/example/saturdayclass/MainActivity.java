package com.example.saturdayclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.saturdayclass.R;

public class MainActivity extends AppCompatActivity {

    Button mBtnCalc,mBtnWeb,mBtnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnCalc = findViewById(R.id.btn_calc);
        mBtnIntent = findViewById(R.id.btn_intent);
        mBtnWeb = findViewById(R.id.btn_web);
       //Set onclick listener for each button

        mBtnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CalculatorActivity.class));
            }
        });


        mBtnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,WebsiteActivity.class));
            }
        });



        mBtnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,IntentActivity.class));
            }
        });

    }
}
