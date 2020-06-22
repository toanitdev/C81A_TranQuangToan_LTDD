package com.toanitdev.nowfake.Utils.Check;

import com.toanitdev.nowfake.utils.CheckUtils;

import org.junit.Assert;
import org.junit.Test;

import static com.toanitdev.nowfake.utils.CheckUtils.isValid;

public class CheckUtilsTest {
  @Test
  public void coGiaTri() {
    Assert.assertTrue(isValid("Toanitdev"));
  }
  @Test
  public void giaTriNull() {

    Assert.assertFalse(isValid(null));
  }
  @Test
  public void giaTriKhoangTrang() {

    Assert.assertTrue(CheckUtils.isValid(" "));
  }
  @Test
  public void rong() {

    Assert.assertFalse(isValid(""));
  }
}
