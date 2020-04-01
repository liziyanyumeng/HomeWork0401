package com.bawei.liziyan20200401.mvp;


import com.bawei.liziyan20200401.base.IBasePreesenter;
import com.bawei.liziyan20200401.bean.RegisterBean;

public class LoginPresenter extends IBasePreesenter<LoginContract.LoginView> implements LoginContract.LoginPresenter {

    private LoginModel loginModel;

    @Override
    public void initModel() {
        loginModel = new LoginModel();
    }
    @Override
    public void login(String phone, String pwd) {
        loginModel.login(phone, pwd, new LoginContract.LoginModel.LoginCallBack() {
            @Override
            public void onSuccessJson(RegisterBean registerBean) {
                view.onSuccessJson(registerBean);
            }
            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}
