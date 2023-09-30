package com.example.project09_05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button btnMkdir, btnRmdir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMkdir = (Button) findViewById(R.id.btnMkdir);
        btnRmdir = (Button) findViewById(R.id.btnRmdir);

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        // 권한요청 창

        String strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath(); // 기본 경로를 strSDpath에 넣기
        final File myDir = new File(strSDpath + "/mydir"); // 기본경로+ 내경로 파일형으로만들어서 파일경로임을 알게함

        btnMkdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 폴더 만들기
                myDir.mkdir();

            }
        });


        btnRmdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.delete();
            }
        });
    }


}