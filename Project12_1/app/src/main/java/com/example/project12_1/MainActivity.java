package com.example.project12_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;
    // 리스트뷰 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list =(ListView) findViewById(R.id.ListView1);
        // 리스트뷰 변수연결

        String [] mid = {"히어로즈", "24시", "로스트", "로스트룸", "스몰빌", "탐정몽크",
                        "빅뱅이론", "프렌즈", "덱스터", "글리", "가쉽걸", "테이큰", "슈퍼내출럴", "브이"};
        // 배열을 만듬

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mid);
                // 어댑터를 만들어서 스트링형을 담음  this 여기 두번째 모양, 스트링배열
        // 하나만 선택하게 함

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, mid);
        // ArrayAdater 라는 중간형태로 바꾸어서 뷰그룹에 출력
        // 여러개를 선택하도록 변경

        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); // 체크박스 라디오버튼등 추가

        list.setAdapter(adapter); // 리스트에 어댑터 추가

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // 리스트가 클릭되었을때
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), mid[i], Toast.LENGTH_SHORT).show();
                // 토스트 출력
            }
        });
    }



}