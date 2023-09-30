package com.example.project07_05;

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


        button1.setOnClickListener(new View.OnClickListener() { // 버튼이 눌리면 작동하게 함
            @Override
            public void onClick(View view) {

                String[] versionArray; // 문자열 배열을 선언함
                versionArray = new String[]{"Q(10)","R(11)","S(12)"};
                // 배열객체를 생성하고 각각의 문자열을 대입
                AlertDialog.Builder dlg; // AlertDialog 객체를 선언
                dlg = new AlertDialog.Builder(MainActivity.this); // 객체를 생성
                dlg.setTitle("좋아하는 버젼은?"); // 타이틀을 설정
                dlg.setIcon(R.mipmap.ic_launcher); // 아이콘을 설정
   /*           dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            // 클릭되면 작동할것
                        button1.setText(versionArray[i]);
                    }
                });

                // SetItems로 세팅할 경우 선택하고 바로 창이 닫히는 문제가 생김

    */

                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 클릭

                        button1.setText(versionArray[i]);

                    } // 선택후 바로 창이 닫히지 않게 하려면 라디오 버튼으로 보이게 해야하는데

                    // 그러기위해서는 setSingleChoiceItems로 AlertDialog.Bulider 객체를 세팅해야함
                    // 이렇게 하면 창이 바로 닫히지 않고 확인할 수있음.
                });

                dlg.setPositiveButton("닫기", null);
                dlg.show();



            }
        });

    }
}