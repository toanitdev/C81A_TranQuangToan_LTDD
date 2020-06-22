package com.toanitdev.nowfake.features.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.features.landing.LandingActivity;

public class SplashActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    LandingActivity.startMe(this);
  }
}
