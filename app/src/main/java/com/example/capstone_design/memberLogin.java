package com.example.capstone_design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class memberLogin extends AppCompatActivity {
    EditText loginIDEditText; //xml파일에서 ID 값 받아올 EditText 변수
    EditText loginPWEditText; //xml파일에서 PW 값 받아올 EditText 변수
    Button loginCheckButton; //로그인 확인 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_login);
        loginIDEditText = (EditText)findViewById(R.id.loginIDedittext);
        loginPWEditText = (EditText)findViewById(R.id.loginPWedittext);
        loginCheckButton = (Button)findViewById(R.id.loginCheckBtn);

        loginCheckButton.setOnClickListener(new View.OnClickListener() { //확인 버튼 눌렀을 때
            @Override
            public void onClick(View view) {

            }
        });
    }
}