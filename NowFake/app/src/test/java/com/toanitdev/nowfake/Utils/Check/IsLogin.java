package com.toanitdev.nowfake.Utils.Check;

import android.app.Activity;
import android.content.Context;

import com.toanitdev.nowfake.BuildConfig;
import com.toanitdev.nowfake.features.login.LoginActivity;
import com.toanitdev.nowfake.utils.PreferenceUtils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class IsLogin {


  LoginActivity loginActivity ;

  @BeforeClass
  public static void start() throws Exception{
    System.out.println("Start");
  }

  @Before
  public void startTest() {
    System.out.println("Start Test case");

  }

  @Test
  public void LoginThanhCong() {
    loginActivity = Robolectric.buildActivity(LoginActivity.class).get();
    PreferenceUtils.saveLoginState(loginActivity,true);
    Assert.assertTrue(PreferenceUtils.loadLoginState(loginActivity));
  }
  @Test
  public void LoginThatBai() {

    loginActivity = Robolectric.buildActivity(LoginActivity.class).get();
    PreferenceUtils.saveLoginState(loginActivity,false);
    Assert.assertFalse(PreferenceUtils.loadLoginState(loginActivity));
  }


  @After
  public void endTest() {
    System.out.println("End Test case");
  }

  @AfterClass
  public static void end() {
    System.out.println("End");
  }
}
