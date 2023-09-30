package com.example.project09_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    Button btnWrite, btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnRead = (Button) findViewById(R.id.btnRead);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                FileOutputStream outFs;
                try {
                    outFs = openFileOutput("File.txt", Context.MODE_PRIVATE);
                    String str = "안드로이드 파일";
                    outFs.write(str.getBytes());// str을 byte로 변환해서 저장
                    outFs.close();
                    Toast.makeText(getApplicationContext(), "file.txt 생성됨", Toast.LENGTH_SHORT).show();

                } catch (IOException e) { // 열고 쓰고 닫고 모두포함
                    throw new RuntimeException(e);
                }


            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inFs = openFileInput("File.txt");
                    byte[] txtarray = new byte[30];
                    inFs.read(txtarray); // txtarray라는 배열에 불러옴 byte
                    String str = new String(txtarray); // byte 형을 string으로 바꿈
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    inFs.close();


                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "파일이 없어요", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

}