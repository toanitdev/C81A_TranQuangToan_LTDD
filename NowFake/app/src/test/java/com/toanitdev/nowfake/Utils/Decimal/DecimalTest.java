package com.toanitdev.nowfake.Utils.Decimal;


import com.toanitdev.nowfake.features.login.LoginActivity;
import com.toanitdev.nowfake.utils.DecimalUtil;
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
public class DecimalTest {
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
    public void format1B() {
      Assert.assertEquals(DecimalUtil.format(1000000000d),"1,000,000,000");
    }
    @Test
    public void format10B() {
      Assert.assertEquals(DecimalUtil.format(100000000000d),"100,000,000,000");
    }
    @Test
    public void formatAm10B() {
      Assert.assertEquals(DecimalUtil.format(-100000000000d),"-100,000,000,000");
    }
    @Test
    public void format0() {
      Assert.assertEquals(DecimalUtil.format(0),"0");
    }
    @Test
    public void formatAm0() {
      Assert.assertEquals(DecimalUtil.format(-0),"0");
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
