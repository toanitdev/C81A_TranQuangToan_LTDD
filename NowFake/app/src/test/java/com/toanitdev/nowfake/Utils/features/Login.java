package com.toanitdev.nowfake.Utils.features;


import com.toanitdev.nowfake.features.login.LoginActivity;
import com.toanitdev.nowfake.features.login.LoginPresenter;
import com.toanitdev.nowfake.features.login.LoginView;
import com.toanitdev.nowfake.models.Response.LoginResponse;
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
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.internal.bytecode.ShadowMap;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class Login {


  LoginActivity loginActivity ;
  LoginPresenter loginPresenter ;
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
    loginPresenter = new LoginPresenter(loginActivity);
    loginActivity  = new LoginActivity() {
      @Override
      public void renderLogin(LoginResponse value) {
        Assert.assertTrue(value.getTinhTrang());
      }
    };

    loginPresenter.login("toanitdev","lklkkl");

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
