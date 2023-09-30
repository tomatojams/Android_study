package com.example.project09_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    DatePicker dp;
    EditText editDiary;
    Button btnWrite;
    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 일기장");

        dp = (DatePicker) findViewById(R.id.dataPicker1);
        editDiary = (EditText) findViewById(R.id.editDiary);
        btnWrite =(Button) findViewById(R.id.btnWrite);

        Calendar Cal = Calendar.getInstance();

        int cYear = Cal.get(Calendar.YEAR);
        int cMonth = Cal.get(Calendar.MONTH);
        int cDay = Cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                filename = Integer.toString(i) +"_" +Integer.toString(i1+1)+"_" +Integer.toString(i2) + ".txt";
                // 파일네임을 연도_월_일.txt

                String str = readDiary(filename);


                editDiary.setText(str);

                btnWrite.setEnabled(true);

            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outs = openFileOutput(filename, Context.MODE_PRIVATE); // filename에 해당하는 파일을 열거나 없으면 만듬
                    String str = editDiary.getText().toString();

                    outs.write(str.getBytes());// 파일 핸들링 오브젝트를 통해 파일에 문자열을 바이트형식으로 적음.
                    outs.close(); // 닫음
                    Toast.makeText(getApplicationContext(),filename + "이 저장됨", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {   /*딱히 에러날 일이 없음.*/         }


            }
        });

    }


    String readDiary(String fName){

        String diaryStr = null; // 리턴할 문자열을 공백으로 만듬
        FileInputStream inFs;

        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt); // byte 형식으로 txt라는 배열에 받아옴
            inFs.close();
            diaryStr = (new String(txt)).trim(); // txt를 String변환후
            // trim은 선행 후행 공백을 제거
            btnWrite.setText(("수정하기"));

        } catch (IOException e) {
            // 에러가 난 경우
            editDiary.setHint("해당날짜 일기없음");
            btnWrite.setText("새로저장"); // 수정해서 저장가능하게
        }
        return diaryStr;

   }
}

