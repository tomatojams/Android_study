package com.example.project11_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity { // 화면으로 쓰기윌해서 Activity
    Button btnReturn;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 두번째 화면 종료 첫번째 화면으로
                finish();


            }
        });

    }
}
