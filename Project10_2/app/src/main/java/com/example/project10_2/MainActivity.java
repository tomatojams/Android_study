package com.example.project10_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final static int Line = 1; // static 자바에서 임의로 삭제 못하게
    final static int Circle = 2;
    static int curShape = Line; // 변화할때

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("간단그림판");
    }


    class MyGraphicView extends View {
        int startX = -1;
        int startY = -1;
        int stopX = -1;
        int stopY = -1;

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    startX = (int)event.getX();
                    startY = (int)event.getY();
                    break;

                case MotionEvent.ACTION_MOVE:


                case MotionEvent.ACTION_UP:
                    stopX = (int)event.getX();
                    stopY = (int) event.getY();
                    this.invalidate();// 온터치 이벤트 무효화 끝 그후에 onDraw 자동실행
                    break;

            }


            return true; // 수정후
        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();

            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.RED);

            switch (curShape){
                case Line:
                    canvas.drawLine(startX,startY,stopX,stopY,paint);
                    break;

                case Circle:
                    int radius = (int) Math.sqrt(Math.pow(stopX - startX,2)
                    +Math.pow(stopY-startY, 2));

                    canvas.drawCircle(startX,startY,radius,paint);
                    break;
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // 선택메뉴

        menu.add(0, 1, 0, "선그리기");
        menu.add(0, 2, 0, "원그리기");
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case 1:
                curShape = Line;
                return true;
            case 2:
                curShape = Circle;
                return true;


        }

        return super.onOptionsItemSelected(item);
    }
}