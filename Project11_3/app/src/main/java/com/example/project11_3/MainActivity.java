package com.example.project11_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNum1, edtNum2;
    Button btnNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인액티비티");


        btnNewActivity = (Button) findViewById(R.id.btnNewAcitivity);
        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                startActivityForResult(intent, 0);


            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OK){
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "합계" +hap, Toast.LENGTH_SHORT).show();
        }

    }
}