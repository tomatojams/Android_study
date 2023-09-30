package com.example.project14_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivBattery;
    EditText edtBattery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivBattery = (ImageView) findViewById(R.id.ivBattery);
        edtBattery =(EditText) findViewById(R.id.edtBattery);


    }


// 상태조정

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br); // 멈춘상태에서 해제

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter iFilter = new IntentFilter();
        iFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br, iFilter); // br 다시 등록

    }

    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();// 배터리상태 가져옴 모든 상태도
            //if 배터리상태
            if(action.equals(Intent.ACTION_BATTERY_CHANGED)){// 배터리상태 가져옴
                int remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                edtBattery.setText("현재충전량: " +remain +"\n");

                if(remain >=90)
                    ivBattery.setImageResource(R.drawable.battery_100);
                else if(remain >=70)
                    ivBattery.setImageResource(R.drawable.battery_80);
                else if(remain >=50)
                    ivBattery.setImageResource(R.drawable.battery_60);
                else if(remain >=10)
                    ivBattery.setImageResource(R.drawable.battery_20);
                else
                    ivBattery.setImageResource(R.drawable.battery_0);

                int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);

                // 배터리 문제가아닐때상태 점검
                switch (plug){
                    case 0:
                        edtBattery.append("전원연결: 안됨");
                        break;

                    case BatteryManager.BATTERY_PLUGGED_USB:
                        edtBattery.append("전원연결: USB");
                        break;
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        edtBattery.append("전원연결: AC");
                        break;
                }


            }

        }
    };



}