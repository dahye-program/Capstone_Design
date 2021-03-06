package com.example.capstone_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class memberSignup extends AppCompatActivity {
    // 회원가입의 회원 정보
    EditText signupNameEditText; //가입자 이름
    EditText signupIDEditText; //가입자 아이디
    EditText signupPWEditText; //가입자 비밀번호
    EditText signupPhoneEditText; //가입자 전화번호
    String nameValue;
    String idValue;
    String pwValue;
    String phoneValue;

    // 나이 선택 라디오그룹버튼
    RadioButton ageTeenageButton;
    RadioButton ageTwentiesButton;
    RadioButton ageThirtiesButton;
    RadioButton ageOnesButton;
    RadioGroup radioGroup;
    String checkAge; // 연령대 저장 변수

    // 성별 선택 라디오그룹버튼
    RadioButton femaleButton;
    RadioButton maleButton;
    RadioGroup radioGroup2;
    String checkSex; // 성별 저장 변수

    Button signUpCheckButton; //xml파일에서 확인 버튼 받아올 Button 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_signup);

        signupNameEditText = (EditText) findViewById(R.id.signupNameedittext); //이름 받아오기
        signupIDEditText = (EditText) findViewById(R.id.signupIDedittext); //아이디 받아오기
        signupPWEditText = (EditText) findViewById(R.id.signupPWedittext); //비밀번호 받아오기
        signupPhoneEditText = (EditText) findViewById(R.id.signupPhoneedittext);  //전화번호 받아오기
        //string 형으로 변환
        nameValue = signupNameEditText.getText().toString();
        idValue = signupIDEditText.getText().toString();
        pwValue = signupPWEditText.getText().toString();
        phoneValue = signupPhoneEditText.getText().toString();

        //나이 라디오 버튼 설정
        ageTeenageButton = (RadioButton) findViewById(R.id.teenageRadioBtn);
        ageTwentiesButton = (RadioButton) findViewById(R.id.twentiesRadioBtn);
        ageThirtiesButton = (RadioButton) findViewById(R.id.thirtiesRadioBtn);
        ageOnesButton = (RadioButton) findViewById(R.id.onesRadioBtn);

        //나이 라디오 그룹 설정
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.teenageRadioBtn) {
                    Toast.makeText(memberSignup.this, "10대 입니다.", Toast.LENGTH_SHORT).show();
                    checkAge = ageTeenageButton.getText().toString();
                } else if (i == R.id.twentiesRadioBtn) {
                    Toast.makeText(memberSignup.this, "20대 입니다.", Toast.LENGTH_SHORT).show();
                    checkAge = ageTwentiesButton.getText().toString();
                } else if (i == R.id.thirtiesRadioBtn) {
                    Toast.makeText(memberSignup.this, "30대 입니다.", Toast.LENGTH_SHORT).show();
                    checkAge = ageThirtiesButton.getText().toString();
                } else if (i == R.id.onesRadioBtn) {
                    Toast.makeText(memberSignup.this, "40대 입니다.", Toast.LENGTH_SHORT).show();
                    checkAge = ageOnesButton.getText().toString();
                }
            }
        });

        //성별 라디오 버튼 설정
        femaleButton = (RadioButton) findViewById(R.id.femaleRadioBtn);
        maleButton = (RadioButton) findViewById(R.id.maleRadioBtn);

        //성별 라디오 그룹 설정
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.femaleRadioBtn) {
                    Toast.makeText(memberSignup.this, "여성 입니다.", Toast.LENGTH_SHORT).show();
                    checkSex = femaleButton.getText().toString();
                } else if (i == R.id.maleRadioBtn) {
                    Toast.makeText(memberSignup.this, "남성 입니다.", Toast.LENGTH_SHORT).show();
                    checkSex = maleButton.getText().toString();
                }
            }
        });

        signUpCheckButton = (Button) findViewById(R.id.signupCheckBtn); //확인 버튼 받아오기
        signUpCheckButton.setOnClickListener(new View.OnClickListener() { //확인 버튼 눌렀을 때
            @Override
            public void onClick(View view) {
                HttpConnectThread http = new HttpConnectThread(
                        "http://192.168.0.104:80/memberSignUp_Android.php",
                        "&username=" + nameValue +
                                "&id=" + idValue + "&pw=" + pwValue +
                                "&phone=" + phoneValue + "&age=" + checkAge + "sex=" + checkSex);
                http.start();
                String temp = http.GetResult();
                if(temp.equals("New record create successfully")){ // 로그인 성공 시
                    Toast.makeText(memberSignup.this, "회원가입 성공",Toast.LENGTH_SHORT).show();
                    // 메인으로 이동
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(memberSignup.this, "회원가입 실패",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}