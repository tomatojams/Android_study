package com.example.project13_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtNumber, edtNameReult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect;

    myDBHelper myHelper;
    SQLiteDatabase sqlDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        edtNameReult = (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumberResult);

        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSelect);

        myHelper = new myDBHelper(this);

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 초기화
                sqlDB = myHelper.getWritableDatabase(); // DB 열기
                myHelper.onUpgrade(sqlDB, 1,2);// 초기화 아무인자나 됨 버리고 새로 생성
                sqlDB.close(); // DB닫기
            }

        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 입력
                sqlDB = myHelper.getWritableDatabase(); // DB열기
                sqlDB.execSQL("INSERT INTO groupTBL VALUES('"
                        + edtName.getText().toString() +"', "
                        +edtNumber.getText().toString() + ");"); // SQL실행
                sqlDB.close(); //DB 닫기
                Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();

            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 조회
                sqlDB = myHelper.getWritableDatabase(); // DB열기
                Cursor cursor; // 커서선언
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);
                // 커서가 첫번째행으로 가게함

                String strNames = "그룹이름" + "\r\n" + "---------" + "\r\n";
                String strNumbers = "인원" + "\r\n" + "---------" + "\r\n";

                while(cursor.moveToNext()) { //커서를 다음행
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers +=cursor.getString(1) +"\r\n";

                }

                edtNameReult.setText(strNames); //텍스트 표시
                edtNumberResult.setText(strNumbers);

                cursor.close(); // 커서닫음
                sqlDB.close(); // DB닫음



            }
        });

    }

    class myDBHelper extends SQLiteOpenHelper{


        public myDBHelper(@Nullable Context context) {
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE groupTBL (gName CHAR(20) PRIMARY KEY, gNumber INTEGER);");

        } //PRIMARY KEY 지우면 안되는 핵심키

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(sqLiteDatabase);

        }
    }




}