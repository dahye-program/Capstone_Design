package com.example.capstone_design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class memberMain extends AppCompatActivity {
    Button runARCameraButton;
    Button showMyrecordButton;
    Button showLocalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_main);
        runARCameraButton = (Button)findViewById(R.id.runCameraBtn);
        showMyrecordButton = (Button)findViewById(R.id.showMyRecordBtn);
        showLocalButton = (Button)findViewById(R.id.showMyRecordBtn);
    }
}