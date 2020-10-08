package com.example.capstone_design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class memberSignup extends AppCompatActivity {
    // 회원가입의 회원 정보
    EditText signupNameEditText; //가입자 이름
    EditText signupIDEditText; //가입자 아이디
    EditText signupPWEditText; //가입자 비밀번호
    EditText signupPhoneEditText; //가입자 전화번호

    // 나이 선택 라디오그룹버튼
    RadioButton ageTeenageButton;
    RadioButton ageTwentiesButton;
    RadioButton ageThirtiesButton;
    RadioButton ageOnesButton;
    RadioGroup radioGroup;
    // 성별 선택 라디오그룹버튼
    RadioButton femaleButton;
    RadioButton maleButton;
    RadioGroup radioGroup2;

    Button signUpCheckButton; //xml파일에서 확인 버튼 받아올 Button 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_signup);

        signupNameEditText = (EditText)findViewById(R.id.signupNameedittext); //이름 받아오기
        signupIDEditText = (EditText)findViewById(R.id.signupIDedittext); //아이디 받아오기
        signupPWEditText = (EditText)findViewById(R.id.signupPWedittext); //비밀번호 받아오기
        signupPhoneEditText = (EditText)findViewById(R.id.signupPhoneedittext);  //전화번호 받아오기

        //나이 라디오 버튼 설정
        ageTeenageButton = (RadioButton)findViewById(R.id.teenageRadioBtn);
        ageTwentiesButton = (RadioButton)findViewById(R.id.twentiesRadioBtn);
        ageThirtiesButton = (RadioButton)findViewById(R.id.thirtiesRadioBtn);
        ageOnesButton = (RadioButton)findViewById(R.id.onesRadioBtn);

        //나이 라디오 그룹 설정
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        // radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) radioGroup); ??

        //성별 라디오 버튼 설정
        femaleButton = (RadioButton)findViewById(R.id.femaleRadioBtn);
        maleButton = (RadioButton)findViewById(R.id.maleRadioBtn);

        //성별 라디오 그룹 설정
        radioGroup2 = (RadioGroup)findViewById(R.id.radioGroup2);
        // radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) radioGroup); ??

        signUpCheckButton = (Button)findViewById(R.id.signupCheckBtn); //확인 버튼 받아오기
        signUpCheckButton.setOnClickListener(new View.OnClickListener() { //확인 버튼 눌렀을 때
            @Override
            public void onClick(View view) {
                //HttpConnectThread http = new HttpConnectThread(
                     //   "http://192.168.0.104:80/insert.php",
                   //     "&status=" + member_status + "&name=" + user_name_text +
                 //               "&number=" + user_number_text);
                //http.start();
                //String temp = http.GetResult();
            }
        });
    }
}