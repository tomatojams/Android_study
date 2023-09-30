package com.example.sony900f;

import android.media.tv.TvInputService;
import android.media.tv.TvInputService.HardwareSession;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new MainFragment())
                    .commitNow();
        }
    }

    HardwareSession


}