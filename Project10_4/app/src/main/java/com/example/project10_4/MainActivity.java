package com.example.project10_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark,ibGray;
    LinearLayout pictureLayout;
    MyGraphicView graphicView;

    //int x

    static float scaleX = 1, scaleY = 1;
    float angle = 0;
    float color = 1;
    float satur = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(new MyGraphicView(this));


        graphicView = (MyGraphicView) new MyGraphicView(this);
        // x = new MyGraphicView (this)

        pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);


       // grphicView가 pictureLayout에 들어가면됨
        pictureLayout.addView(graphicView);

        clickIcons();



    }

    class MyGraphicView extends View {


        public MyGraphicView(Context context) {
            super(context);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth()/2;
            int cenY = this.getHeight()/2;
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Paint paint = new Paint();
            float[] array = { 1, 0, 0, 0, 0,
                              0, 1, 0, 0, 0,
                              0, 0, 1, 0, 0,
                              0, 0,  0, 0.5f, 0};
            ColorMatrix cm = new ColorMatrix(array);
            // 칼라메트릭스로 칼라값 확정
            if(satur == 0)cm.setSaturation(satur);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));
            // 해당칼라가 페인트 옵션으로 세팅


            // 이미 회색일때는 그대로

            Bitmap picture = BitmapFactory.decodeResource(getResources(),
                    R.drawable.lena256);

            int picX = (this.getWidth() - picture.getWidth()) /2;
            int picY = (this.getHeight() - picture.getHeight())/2;
            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();

        }
    }

    void clickIcons(){
        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX = scaleX +0.2f;
                scaleY = scaleY +0.2f;
                graphicView.invalidate();//확대후 해제


            }
        });

        ibZoomout = (ImageButton) findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX = scaleX -0.2f;
                scaleY = scaleY -0.2f;
                graphicView.invalidate();//확대후 해제
            }
        });

        ibRotate = (ImageButton) findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle = angle + 20;
                graphicView.invalidate();//확대후 해제
            }
        });

        ibBright = (ImageButton) findViewById(R.id.ibBright);
        ibBright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = color + 0.2f;
                graphicView.invalidate();//확대후 해제
            }
        });

        ibDark = (ImageButton) findViewById(R.id.ibDark);
        ibDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = color - 0.2f;
                graphicView.invalidate();//확대후 해제
            }
        });

        ibGray = (ImageButton) findViewById(R.id.ibGray);
        ibDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (satur == 0)
                    satur = 1;
                else
                    satur = 0;

                graphicView.invalidate();//확대후 해제
            }
        });



    }





}