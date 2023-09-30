package com.example.project04_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit1,edit2;
    //int x 변수를 선언한다.

    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;

    // 버튼, 텍스트뷰 변수를 선언하고 계산에 쓰이는 num1,num2와 result를 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단계산기"); // 앱상단의 타이틀 이름
        edit1 = (EditText)findViewById(R.id.edit1);
        //x = 10;
        edit2 = (EditText) findViewById(R.id.edit2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        textResult =(TextView) findViewById(R.id.textResult);
        // 선언한 변수를 텍스트뷰 ,버튼등의 객체와 연결해준다. R.id. 는 리소스에서 id로 찾는다.


        btnAdd.setOnTouchListener(new View.OnTouchListener() { // 버튼이 터치될때 발동하는 함수
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //버튼이 눌리면 작동하는 함수
                num1 = edit1.getText().toString(); // num1 객체에서 텍스트를 받아서 String으로 변환해 num1에 넣는다
                num2 = edit2.getText().toString(); // 마친가지로 String으로 변환 num2에 넣는다
                result =Integer.parseInt(num1) + Integer.parseInt(num2); // num1과 num2가 String이므로 integer로 변환해서 계산한 뒤에 result에 넣음
                textResult.setText("계산결과:"+result.toString()); // result를 String으로 변한해서 출력
                return false;
            }
        });


        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result =Integer.parseInt(num1) - Integer.parseInt(num2); // 모두 동일하고 연산자만 달라짐.
                textResult.setText("계산결과:"+result.toString());

                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result =Integer.parseInt(num1) * Integer.parseInt(num2); //parseInt는 문자열을 숫자로 바꿔줌 숫자형 문자일 경우에만
                textResult.setText("계산결과:"+result.toString());

                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result =Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산결과:"+result.toString());
                return false;
            }
        });


    }
}