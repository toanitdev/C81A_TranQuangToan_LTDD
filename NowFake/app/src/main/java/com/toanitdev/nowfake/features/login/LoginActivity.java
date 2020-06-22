package com.toanitdev.nowfake.features.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.toanitdev.nowfake.features.signup.SignUpActivity;
import com.toanitdev.nowfake.models.Response.LoginResponse;
import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.utils.CheckUtils;
import com.toanitdev.nowfake.utils.PreferenceUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView {
  TextView textView;
  LoginPresenter presenter;

  @BindView(R.id.tvLogin)
  TextView tvLogin;
  @BindView(R.id.imgBack)
  ImageView imgBack;
  @BindView(R.id.edtUser)
  EditText edtUser;
  @BindView(R.id.edtPassword)
  EditText edtPassword;
  @BindView(R.id.tvSignUp)
  TextView tvSignUp;

  ProgressDialog progressDialog;

  public static void startMe(Context context) {
    Intent intent = new Intent(context, LoginActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onStart() {
    super.onStart();
    progressDialog = new ProgressDialog(this);
    progressDialog.setTitle("Vui lòng chờ ...");
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);
    textView = findViewById(R.id.txtHello);

    presenter = new LoginPresenter(this);
    setOnClick();
  }

  private void setOnClick() {
    tvLogin.setOnClickListener((View v) -> {
      if(CheckUtils.isValid(edtPassword.getText().toString())&& CheckUtils.isValid(edtUser.getText().toString())){

        progressDialog.show();
        presenter.login(edtUser.getText().toString(),edtPassword.getText().toString());
      }
      else
        Toast.makeText(this,"Vui lòng nhập đầy đủ",Toast.LENGTH_SHORT).show();
    });
    imgBack.setOnClickListener((v)->{finish();});
    tvSignUp.setOnClickListener(v -> {
      SignUpActivity.startMe(LoginActivity.this);
    });
    //password action
    edtPassword.setOnEditorActionListener(((v, actionId, event) -> {

    if(CheckUtils.isValid(edtPassword.getText().toString())&& CheckUtils.isValid(edtUser.getText().toString())){
       progressDialog.show();
       presenter.login(edtUser.getText().toString(),edtPassword.getText().toString());
    }
    else
      Toast.makeText(this,"Vui lòng nhập đầy đủ.",Toast.LENGTH_SHORT).show();
    return true;}));
  }


  @Override
  public void renderLogin(LoginResponse value) {
    progressDialog.dismiss();
      Toast.makeText(this,""+value.getLoiNhan(),Toast.LENGTH_SHORT).show();
      if(value.getTinhTrang()){
        PreferenceUtils.saveCustomerDetail(this,value.getUserName(),value.getIdCustomer());
        finish();
      }
      PreferenceUtils.saveLoginState(this,value.getTinhTrang());
  }
}
