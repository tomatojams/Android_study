package com.example.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 어플커짐
        super.onCreate(savedInstanceState); // 어플커지고 레이어 생기고
       // setContentView(R.layout.activity_main);  // 지정한 화면을 보여줘라

        setContentView(new MyGraphicView(this)); // 우리가 그린그림으로 수정
        //클래스 생성은 new 사용
    }

    // 1단계 그림그릴 클래스 만들기
    class MyGraphicView extends View { // 그림그리는 클래스


        public MyGraphicView(Context context) {
            super(context);
        }
       // 2단계 View 클래스안에 캔버스와 페인트 세팅
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas); // 캔버스
            Paint paint = new Paint(); // 페인트
            // int x = 10

            paint.setAntiAlias(true); // 외곽선 다듬기
            paint.setColor(Color.GREEN);
            paint.setStrokeWidth(10);
            canvas.drawLine(20, 20, 600, 20, paint);

            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(10);
            canvas.drawLine(20, 60, 600, 60, paint);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(0);

            paint.setStyle(Paint.Style.FILL); // 채우기
            Rect rect1 = new Rect(20, 100, 20+200, 100+200);
            canvas.drawRect(rect1, paint);

            paint.setStyle(Paint.Style.STROKE); // 선
            Rect rect2 = new Rect(260, 100, 260+200, 100+200);
            canvas.drawRect(rect2, paint);

            RectF rect3 = new RectF(500, 100, 500+200, 100+200);
            canvas.drawRoundRect(rect3, 40, 40, paint);

            canvas.drawCircle(120, 440, 100, paint);

            paint.setStrokeWidth(5);
            Path path1 = new Path();
            path1.moveTo(20, 580);
            path1.lineTo(20+100, 580+100);
            path1.lineTo(20+200, 580);
            path1.lineTo(20+300, 580+100);
            path1.lineTo(20+400, 580);
            canvas.drawPath(path1,paint);

            paint.setStrokeWidth(0);
            paint.setTextSize(60);
            canvas.drawText("안드로이드", 20, 780, paint);



        }


    }
}