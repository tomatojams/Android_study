package com.example.project07_04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dlg; // 대화상자 클래스 받기
                dlg = new AlertDialog.Builder(MainActivity.this); // x=10 (this->이화면)
                dlg.setTitle("제목입니다");
                dlg.setMessage("이곳은 내용");
                dlg.setIcon(R.mipmap.ic_launcher); // 아이콘 리소스 밉맵에서 가져옴
               // dlg.setPositiveButton("확인", null); //확인버튼
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override                // 버튼안에 클릭함수
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 클릭이 되었을때
                        Toast.makeText(MainActivity.this, "확인을 눌렀어요",Toast.LENGTH_SHORT).show();
                             //MainActivity 메인 이화면이 떴을때
                    }
                });
                dlg.show();
            }
        });



    }
}