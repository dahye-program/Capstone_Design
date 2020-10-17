package com.example.capstone_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class memberLogin extends AppCompatActivity {
    EditText loginIDEditText; //xml파일에서 ID 값 받아올 EditText 변수
    EditText loginPWEditText; //xml파일에서 PW 값 받아올 EditText 변수
    Button loginCheckButton; //로그인 확인 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_login);
        loginIDEditText = (EditText) findViewById(R.id.loginIDedittext);
        loginPWEditText = (EditText) findViewById(R.id.loginPWedittext);
        loginCheckButton = (Button) findViewById(R.id.loginCheckBtn);

        loginCheckButton.setOnClickListener(new View.OnClickListener() { //확인 버튼 눌렀을 때
            @Override
            public void onClick(View view) {
                if (loginIDEditText.getText().toString().equals("") || loginPWEditText.getText().toString().equals("")) {
                    Toast.makeText(memberLogin.this, "입력 제대로 하세요!!", Toast.LENGTH_SHORT).show();
                } else {
                    HttpConnectThread http = new HttpConnectThread(
                            "http://192.168.0.101:80/memberLogin_Android.php",
                            "&id=" + loginIDEditText +
                                    "&pw=" + loginPWEditText);
                    http.start();
                    String temp = http.GetResult();
                    if(temp.equals("Login Successfully")){ // 로그인 성공 시
                        Toast.makeText(memberLogin.this, "로그인 성공",Toast.LENGTH_SHORT).show();
                        // 회원 메인으로 이동
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(memberLogin.this, "로그인 실패",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}