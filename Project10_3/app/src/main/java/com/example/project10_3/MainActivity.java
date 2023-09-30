package com.example.project10_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }


    class MyGraphicView extends View {

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap picture; // 이미지 불러올 클래스
            picture = BitmapFactory.decodeResource(getResources(), R.drawable.jeju14);

            int picX = (this.getWidth() - picture.getWidth())/2; //중앙에 불러옴
            int picY = (this.getHeight() - picture.getHeight())/2;
            canvas.drawBitmap(picture, picX, picY,null); // 이미지 그림
            picture.recycle();
        }
    }
}