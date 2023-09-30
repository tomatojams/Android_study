package com.example.project07_03;

import androidx.appcompat.app.AppCompatActivity;

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
                //
                //Toast.makeText(getApplicationContext(), "토스트연습", Toast.LENGTH_SHORT).show();
                Toast tMsg;
                tMsg = Toast.makeText(getApplicationContext(), "토스트연습", Toast.LENGTH_SHORT);
                tMsg.show();
                        //getApplicationContext() 현재의 어플리케이션화면에
            }
        });

    }


}