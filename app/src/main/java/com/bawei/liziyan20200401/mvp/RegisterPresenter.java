package com.bawei.liziyan20200401.mvp;

import com.bawei.liziyan20200401.base.IBasePreesenter;
import com.bawei.liziyan20200401.bean.RegisterBean;

public class RegisterPresenter extends IBasePreesenter<RegisterContract.RegisterView> implements RegisterContract.RegisterPresenter {

    private RegisterModel registerModel;

    @Override
    public void initModel() {
        registerModel = new RegisterModel();
    }
    @Override
    public void register(String phone, String pwd) {
        registerModel.register(phone, pwd, new RegisterContract.RegisterModel.RegisterCallBack() {
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
