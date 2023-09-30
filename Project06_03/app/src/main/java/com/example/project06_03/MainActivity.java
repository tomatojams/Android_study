package com.example.project06_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editUrl;
    Button btnGo, btnBack;

    WebView web;
    //변수선언




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUrl = (EditText) findViewById(R.id.edtUrl);// 선언한 변수와 xml상의 버튼등과 연결한다.
        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        web = (WebView) findViewById(R.id.webView1); // 웹뷰객체
        // x =10
        web.setWebViewClient(new CookWebView()); // web을 웹뷰 클라이언트로 세팅
        // 페이지 컨트롤 함수, 다양한 요청, 알림 을 수신하는 기능을 한다.


        WebSettings webSet = web.getSettings(); // 자바문법 webset 변수 webSetting 메소드
        // 웹뷰를 쓸때 기능등을 설정하는 object 그럴때 WebSetting의 인스턴스를 하나 선언핸야한다 webset과 같이
        //

        webSet.setBuiltInZoomControls(true); // 줌이가능하게 기능설정
        webSet.setJavaScriptEnabled(true); // 자바 스크립트 가능하게 설정
        // 그외에 webSettings.setSupportMultipleWindows(true); 여러 윈도우를 쓰게 하거나
        // webSettings.setBuiltInZoomControls(true); 안드로이드에서 제공하는 줌 아이콘을 쓰게 할수도있다.

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.loadUrl(editUrl.getText().toString()); //url을 받아서 띄워라
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.goBack();
            }
        });



    }

    class CookWebView extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }


}