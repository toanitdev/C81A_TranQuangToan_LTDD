package com.toanitdev.nowfake.features.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.features.landing.LandingActivity;
import com.toanitdev.nowfake.interactor.Signup;
import com.toanitdev.nowfake.models.Response.ResultResponse;
import com.toanitdev.nowfake.utils.CheckUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements SignUpView {


  SignUpPresenter presenter;

  @BindView(R.id.edtPhone)
  EditText edtPhone;
  @BindView(R.id.edtUsername)
  EditText edtUsername;
  @BindView(R.id.edtPassword)
  EditText edtPassword;
  @BindView(R.id.edtConfirmPassword)
  EditText edtConfirmPassword;
  @BindView(R.id.edtName)
  EditText edtName;
  @BindView(R.id.edtDod)
  EditText edtDod;
  @BindView(R.id.edtEmail)
  EditText edtEmail;
  @BindView(R.id.tvSignUp)
  TextView tvSignUp;


  public static void startMe(Context context){
    Intent intent = new Intent(context,SignUpActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up);
    ButterKnife.bind(this);

    presenter = new SignUpPresenter(this);

    setOnClick();
  }

  private void setOnClick() {
    tvSignUp.setOnClickListener(v -> {
      if(isValidate()){
        presenter.signup(edtUsername.getText().toString(),edtPassword.getText().toString(),edtName.getText()
            .toString(),edtPhone.getText().toString(),edtEmail.getText().toString(),edtDod.getText().toString());
      }else {
        Toast.makeText(this,"Vui lòng không để trống",Toast.LENGTH_SHORT).show();
      }
    });
    edtDod.setOnClickListener(v -> {
      Calendar calendar = Calendar.getInstance();
      int month = calendar.get(Calendar.MONTH);
      int date = calendar.get(Calendar.DATE);
      int year = calendar.get(Calendar.YEAR);
      DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int y, int m, int dayOfMonth) {
          calendar.set(y,m,dayOfMonth);
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          edtDod.setText(simpleDateFormat.format(calendar.getTime()));
        }
      },year,month,date);
      datePickerDialog.show();
    });
  }


  @Override
  public void renderResultSuccess(ResultResponse resultResponse) {
    Toast.makeText(this,resultResponse.getMessage(),Toast.LENGTH_SHORT).show();
    LandingActivity.startMeTop(this);
  }

  @Override
  public void renderResultFailed(ResultResponse resultResponse) {
    Toast.makeText(this,resultResponse.getMessage(),Toast.LENGTH_SHORT).show();
  }

  @Override
  public void renderResultError(Throwable throwable) {
    Toast.makeText(this,throwable.getMessage(),Toast.LENGTH_SHORT).show();
  }

  boolean isValidate(){
    if(CheckUtils.isValid(edtUsername.getText().toString())
        &&CheckUtils.isValid(edtPassword.getText().toString())
        &&CheckUtils.isValid(edtConfirmPassword.getText().toString())
        &&CheckUtils.isValid(edtEmail.getText().toString())
        &&CheckUtils.isValid(edtDod.getText().toString())
        &&CheckUtils.isValid(edtName.getText().toString())
        &&CheckUtils.isValid(edtPhone.getText().toString())){
      return true;
    }
    return false;
  }
}
