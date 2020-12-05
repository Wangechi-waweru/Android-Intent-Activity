package com.example.saturdayclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    TextView mTvAnswer;
    EditText mEdFnum,mEdtSnum;
    Button mBtnAdd,mBtnSubtract,mBtnDivision,mBtnMutiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvAnswer = findViewById(R.id.txt_answer);
        mEdFnum = findViewById(R.id.edt_fno);
        mEdtSnum = findViewById(R.id.edt_sno);
        mBtnAdd = findViewById(R.id.btn_add);
        mBtnDivision = findViewById(R.id.btn_divide);
        mBtnMutiply = findViewById(R.id.btn_multiply);
        mBtnSubtract = findViewById(R.id.btn_subtract);

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Receive numbers provided by the user.
                String first_number = mEdFnum.getText().toString();
                String second_number = mEdtSnum.getText().toString();

                //Check if the user is submitting an empty field.
                if (first_number.isEmpty()){
                    mEdFnum.setError("Please enter your first number");
                }else if(second_number.isEmpty()){
                    mEdtSnum.setError("Please enter your second number");
                }else{
                    //Do the calculation.
                    Double answer = Double.parseDouble(first_number ) + Double.parseDouble(second_number);

                    //Display the answer to our text view.
                    mTvAnswer.setText(String.valueOf(answer));
                }

            }
        });

        mBtnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Receive numbers provided by the user.
                String first_number = mEdFnum.getText().toString();
                String second_number = mEdtSnum.getText().toString();

                //Check if the user is submitting an empty field.
                if (first_number.isEmpty()){
                    mEdFnum.setError("Please enter your first number");
                }else if(second_number.isEmpty()){
                    mEdtSnum.setError("Please enter your second number");
                }else{
                    //Do the calculation.
                    Double answer = Double.parseDouble(first_number ) - Double.parseDouble(second_number);

                    //Display the answer to our text view.
                    mTvAnswer.setText(String.valueOf(answer));
                }


            }
        });

        mBtnMutiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Receive numbers provided by the user.
                String first_number = mEdFnum.getText().toString();
                String second_number = mEdtSnum.getText().toString();

                //Check if the user is submitting an empty field.
                if (first_number.isEmpty()){
                    mEdFnum.setError("Please enter your first number");
                }else if(second_number.isEmpty()){
                    mEdtSnum.setError("Please enter your second number");
                }else{
                    //Do the calculation.
                    Double answer = Double.parseDouble(first_number ) * Double.parseDouble(second_number);

                    //Display the answer to our text view.
                    mTvAnswer.setText(String.valueOf(answer));
                }


            }
        });
        mBtnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Receive numbers provided by the user.
                String first_number = mEdFnum.getText().toString();
                String second_number = mEdtSnum.getText().toString();

                //Check if the user is submitting an empty field.
                if (first_number.isEmpty()){
                    mEdFnum.setError("Please enter your first number");
                }else if(second_number.isEmpty()){
                    mEdtSnum.setError("Please enter your second number");
                }else{
                    //Do the calculation.
                    Double answer = Double.parseDouble(first_number ) / Double.parseDouble(second_number);

                    //Display the answer to our text view.
                    mTvAnswer.setText(String.valueOf(answer));
                }


            }
        });

    }
}

