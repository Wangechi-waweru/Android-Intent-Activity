package com.example.saturdayclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentActivity extends AppCompatActivity {

    //Declaring variables

    Button mBtnSMS, mBtnStk, mBtnEmail, mBtnDial, mBtnShare, mBtnCamera, mBtnCall;
    EditText mEdPhonenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        //Set find view by Id for each button.

        mBtnSMS = findViewById(R.id.btn_sms);
        mBtnStk = findViewById(R.id.btn_stk);
        mBtnEmail = findViewById(R.id.btn_email);
        mBtnDial = findViewById(R.id.btn_dial);
        mBtnShare = findViewById(R.id.btn_share);
        mBtnCamera = findViewById(R.id.btn_camera);
        mBtnCall = findViewById(R.id.btn_call);


        //Set onclick listener for each button

        mBtnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(("smsto:0700000000"));
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                intent.putExtra("sms_body","Hello, Sir. I won't be able to make it to .......");
                startActivity(intent);
            }
        });

        mBtnStk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent simToolKitLaunchIntent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.android.stk");
                    if(simToolKitLaunchIntent != null){
                    startActivity(simToolKitLaunchIntent);
                }
            }
        });

        mBtnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","king@gmail.com",null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "KUOMBA KAZI");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Hsujambo mkurugenzi mpendwa, naadika ujumbe huu ilimradi kuomba kazi....");
                     startActivity(Intent.createChooser(emailIntent, "SENDING EMAIL"));
            }
        });

        mBtnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "+2547";
                        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",phone,null));
                        startActivity(intent);
            }
        });

        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent shareIntent= new Intent(Intent.ACTION_SEND);
                shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,"Hello there, please click on https://www.mywebsite.com/playstore to download my app");
                startActivity(shareIntent);
            }
        });

        mBtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePictureIntent, 1);
            }
        });

        mBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Receive a phone number from the phone number field
                String phone =  mEdPhonenum.getText().toString();
                if (phone.isEmpty()) {
                    mEdPhonenum.setError("Please enter phone number");
                }else if (phone.length()<10){
                    mEdPhonenum.setError("Please enter valid phone number");
                }else{
                    Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+ phone));
                    if (ContextCompat.checkSelfPermission(IntentActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(IntentActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                    }else{
                        startActivity(intent);
                    }
                }
            }
        });










    }
}
