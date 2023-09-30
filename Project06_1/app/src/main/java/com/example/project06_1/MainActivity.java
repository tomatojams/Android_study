package com.example.project06_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    // xml 에서 만든 변수 선언 int x
    Chronometer chronometer1;

    Button btnStart,btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

    int selectYear, selectMonth, selectDay;

    // 해당변수에 값넣기 x = 10



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간 예약 앱");

        chronometer1 =(Chronometer) findViewById(R.id.chronometer1);

        btnStart =(Button) findViewById(R.id.btnStart);
        btnEnd =(Button) findViewById(R.id.btnEnd);

        rdoCal =(RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        tPicker =(TimePicker) findViewById(R.id.timePic1);
        calView = (CalendarView) findViewById(R.id.calView1);

        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth =(TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute =(TextView) findViewById(R.id.tvMinute);

        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);


        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 작동할 내용

                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calView.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);

            }
        });



        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chronometer1.setBase(SystemClock.elapsedRealtime());
                chronometer1.start();
                chronometer1.setTextColor(Color.RED);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chronometer1.stop();
                chronometer1.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMonth.setText(Integer.toString(tPicker.getCurrentMinute()));
            }
        });

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                selectYear = i;
                selectMonth = i1+1;
                selectDay = i2;
            }
        });



    }
}