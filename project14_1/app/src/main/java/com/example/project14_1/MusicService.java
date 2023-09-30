package com.example.project14_1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    MediaPlayer mp;

    @Nullable
    @Override


    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        android.util.Log.i("서비스테스트", "onCreate()");
                //상태가 바뀔때 Logcat에 표시
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        mp.stop();
        android.util.Log.i("서비스테스트", "onDestroy()"); // 음악 나오지 않게
        // 강의와 달리 onDestroy로 수정했음
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) { //음악나오게
        android.util.Log.i("서비스테스트", "onStartCommand()");
        // 강의랑 달리 onStartComand로 수정했음
        mp =MediaPlayer.create(this, R.raw.song1);
        mp.setLooping(true); //반복설정
        mp.start(); // 음악시작


        return super.onStartCommand(intent, flags, startId);
    }
}
