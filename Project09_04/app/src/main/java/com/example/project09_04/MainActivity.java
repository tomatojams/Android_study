package com.example.project09_04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnRead;
    EditText edtSD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = (Button) findViewById(R.id.btnRead);
        edtSD = (EditText) findViewById(R.id.edtSD);

        // 추가코드 외부SD카드에 쓰기 권한요청
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                try {
                    FileInputStream inFs = new FileInputStream(("/storage/emulated/0/aa.txt"));
                    byte[] txt = new byte[inFs.available()];
                    inFs.read(txt); // 읽어서 바이트를 txt 배열에 넣기
                    edtSD.setText(new String(txt)); // byte형인 txt를 문자열려 변환해서 넣음
                    inFs.close(); // 파일닫기

                } catch (IOException e) {

                }

            }
        });


    }
}