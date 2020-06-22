package com.toanitdev.nowfake.features.shipping_page;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.features.review_oder.ReviewActivity;
import com.toanitdev.nowfake.utils.CheckUtils;

import java.util.regex.Matcher;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShippingActivity extends AppCompatActivity {

  @BindView(R.id.tvOrder)
  TextView tvOrder;


  @BindView(R.id.edtNumber)
  EditText edtNumber;
  @BindView(R.id.edtCity)
  EditText edtCity;
  @BindView(R.id.edtDistrict)
  EditText edtDistrict;
  @BindView(R.id.edtPhone)
  EditText edtPhone;
  @BindView(R.id.edtStreet)
  EditText edtStreet;
  @BindView(R.id.edtWard)
  EditText edtWard;

  @BindView(R.id.imgBack)
  ImageView imgBack;

  String numberPhone;

  static int len ;
  public static void startMe(Context context){
    Intent intent = new Intent(context,ShippingActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shipping);
    ButterKnife.bind(this);




    //edtPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

    //PhoneNumberUtils.formatNumber(edtPhone.getText().toString());
    setEdtPhone();
    //set onclick
    setOnClick();
  }

  void setOnClick(){
    tvOrder.setOnClickListener(v -> {
      numberPhone = edtPhone.getText().toString();
      numberPhone=numberPhone.trim().replaceAll("[()-+.^:, -]","");
      if(isValidate()){
        String address = edtNumber.getText().toString()+", "
            +edtStreet.getText().toString()+", "
            +edtWard.getText().toString()+", "
            +edtDistrict.getText().toString()+", "
            +edtCity.getText().toString();
        String phone  =edtPhone.getText().toString().endsWith("-")? edtPhone.getText().toString().substring(0,edtPhone.getText().length()-1):edtPhone.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("address",address);
        bundle.putString("phone",phone);
        ReviewActivity.startMe(this, bundle);
      }else {
        new AlertDialog.Builder(this).setTitle("Thông báo !")
            .setMessage("Vui lòng nhập đầy đủ thông tin !").show();
      }
    });
    imgBack.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
  }
  void setEdtPhone(){

      edtPhone.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
          len =count;
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
          if(len<count)
            if((edtPhone.getText().toString().length()==3
                ||edtPhone.getText().toString().length()==7
                ||edtPhone.getText().toString().length()==11)){
              edtPhone.getText().append("-");
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
      });
  }
  boolean isValidate(){
    if(CheckUtils.isValid(edtCity.getText().toString())
        &&CheckUtils.isValid(edtDistrict.getText().toString())
        &&CheckUtils.isValid(edtNumber.getText().toString())
        &&CheckUtils.isValid(edtPhone.getText().toString())
        &&CheckUtils.isValid(edtStreet.getText().toString())
        &&CheckUtils.isValid(edtWard.getText().toString())){
      return true;
    }
    return false;
  }


}
