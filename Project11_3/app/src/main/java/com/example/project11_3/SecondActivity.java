package com.example.project11_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends Activity {

    Button btnResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("두번째 액티비티");

        Intent intent = getIntent();
        int hapValue = intent.getIntExtra("Num1",0) +intent.getIntExtra("Num2", 0);


        btnResult = (Button) findViewById(R.id.btnReturn);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Hap", hapValue);
                setResult(RESULT_OK, outIntent); // 세컨드 액티비티에만 있음 첫번째로메세지
                finish();


            }
        });

    }
}
