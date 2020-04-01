package com.bawei.liziyan20200401;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.liziyan20200401.base.BaseActivity;
import com.bawei.liziyan20200401.bean.RegisterBean;
import com.bawei.liziyan20200401.bean.RegisterResultBean;
import com.bawei.liziyan20200401.bean.ResultBean;
import com.bawei.liziyan20200401.mvp.LoginContract;
import com.bawei.liziyan20200401.mvp.LoginPresenter;
import com.bawei.liziyan20200401.util.SpUtil;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginView {

private android.widget.EditText loginPhone;
private android.widget.EditText loginPwd;
private String phone;
private String pwd;
    private Button btLogin;
    private Button btRegister;

    @Override
public int initLayoutId() {
        return R.layout.activity_login;
        }

@Override
public LoginPresenter initModel() {
        return new LoginPresenter();
        }

@Override
public void initView() {
        loginPhone = (EditText) findViewById(R.id.login_phone);
        loginPwd = (EditText) findViewById(R.id.login_pwd);

    btLogin = (Button) findViewById(R.id.bt_login);
    btRegister = (Button) findViewById(R.id.bt_register);
}

@Override
public void initListener() {
        btRegister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
            finish();
        }
        });
        btLogin.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        phone = loginPhone.getText().toString();
        pwd = loginPwd.getText().toString();
        p.login(phone, pwd);
        }
        });
        }

@Override
public void initData() {
    final Intent intent = getIntent();
        String phone = intent.getStringExtra("phone");
        String pwd = intent.getStringExtra("pwd");
        if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(pwd)){
        loginPhone.setText(phone);
        loginPwd.setText(pwd);
        }
        }


    @Override
    public void onSuccessJson(RegisterBean registerBean) {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        final RegisterResultBean result = registerBean.result;
        //使用SP存储数据
        SpUtil.saveString("headPic",result.headPic);
        SpUtil.saveString("nickName",result.nickName);
        SpUtil.saveString("phone",result.phone);
        SpUtil.saveString("sessionId",result.sessionId);
        SpUtil.saveInt("userId",result.userId);
        final Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
public void onFailureJson(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        }
