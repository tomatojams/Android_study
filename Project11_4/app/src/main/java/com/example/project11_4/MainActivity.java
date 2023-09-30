package com.example.project11_4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDial, btnWeb, btnGoogle, btnSearch, btnSms, btnPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("암시적인텐트 예제");


        btnDial = (Button) findViewById(R.id.btnDial);
        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnGoogle = (Button) findViewById(R.id.btnGoogle);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSms =(Button) findViewById(R.id.btnSms);
        btnPhoto = (Button) findViewById(R.id.btnPhoto);

        btnDial.setOnClickListener(new View.OnClickListener() { // 전화걸기
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("tel:010-1234"); // 미리 적어둔 번호로 전화검
                Intent intent = new Intent(Intent.ACTION_DIAL, uri); // 암시적인텐트
                startActivity(intent);} // 암시적 인텐트 시작
        });

        btnWeb.setOnClickListener(new View.OnClickListener() { // 웹페이지열기
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.naver.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri); // 인터넷 열기 암시적 인텐트
                startActivity(intent); }
        });
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("https://maps.google.co.kr/maps?q="+ 37.559133 + "," + 126.927824 + "&z=15");
                // 구글 맵열기
                Intent intent = new Intent(Intent.ACTION_VIEW, uri); //  암시적 인텐트
                startActivity(intent); }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH); // 검색열기
                intent.putExtra(SearchManager.QUERY, "안드로이드");// 넘겨줄 정보 넣기
                startActivity(intent); }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO); // 메세지 보내기
                intent.putExtra("sms_body", "안녕하세요?"); // 추가정보 넣기
                intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-4567"))); // SMS보내는 암시적 인텐트
                startActivity(intent); }
        });
        btnPhoto.setOnClickListener(new View.OnClickListener() { // 사진찍기
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore. ACTION_IMAGE_CAPTURE); // 사진앱실행
                startActivity(intent); }
        });


    }
}