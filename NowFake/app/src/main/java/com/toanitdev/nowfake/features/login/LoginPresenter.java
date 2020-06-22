package com.toanitdev.nowfake.features.login;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.toanitdev.nowfake.interactor.Login;
import com.toanitdev.nowfake.models.Response.LoginResponse;

import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginPresenter<T extends AppCompatActivity>  {

    Login login;
    LoginActivity activity;

    public LoginPresenter(T activity) {
        login = new Login();
        this.activity = (LoginActivity) activity;
    }

    public void login(String user ,String password){
        login.excute(user,password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .toSingle().subscribe(new SingleSubscriber<LoginResponse>() {
                    @Override
                    public void onSuccess(LoginResponse value) {
                        Log.d("TEGGGGGG",value.getLoiNhan());
                        Log.d("RESULT",value.getLoiNhan());
                        activity.renderLogin(value);
                    }

                    @Override
                    public void onError(Throwable error) {

                    }
                });
    }
}
