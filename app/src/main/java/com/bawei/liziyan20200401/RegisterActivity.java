package com.bawei.liziyan20200401;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.liziyan20200401.base.BaseActivity;
import com.bawei.liziyan20200401.bean.RegisterBean;
import com.bawei.liziyan20200401.mvp.RegisterContract;
import com.bawei.liziyan20200401.mvp.RegisterPresenter;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.RegisterView {

    private EditText registerPhone;
    private EditText registerPwd;
    private Button register;
    private String phone;
    private String pwd;

    @Override
    public int initLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public RegisterPresenter initModel() {
        return new RegisterPresenter();
    }

    @Override
    public void initView() {
        registerPhone = (EditText) findViewById(R.id.register_phone);
        registerPwd = (EditText) findViewById(R.id.register_pwd);
        register = (Button) findViewById(R.id.register);
    }

    @Override
    public void initListener() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = registerPhone.getText().toString();
                pwd = registerPwd.getText().toString();
                p.register(phone,pwd);
            }
        });
    }

    @Override
    public void initData() {}

    @Override
    public void onSuccessJson(RegisterBean registerBean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        final Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
        intent.putExtra("phone",phone);
        intent.putExtra("pwd",pwd);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFailureJson(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
