package com.example.project14_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent intent; // 서비스는 명령어를 Intent형식으로 받음
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, MusicService.class);
        // 서비스를 위한 인텐트 선언

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startService(intent); // 서비스시작
                android.util.Log.i("서비스테스트", "startService()");
                // 로그캣에서 보여줌


            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopService(intent); // 서비스 중지
                android.util.Log.i("서비스테스트", "stopService()");
                // 로그캣에서 보게함


            }
        });

    }
}