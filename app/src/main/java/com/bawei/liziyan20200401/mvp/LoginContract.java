package com.bawei.liziyan20200401.mvp;

import com.bawei.liziyan20200401.base.IBaseView;
import com.bawei.liziyan20200401.bean.RegisterBean;

public interface LoginContract {
    interface LoginView extends IBaseView {
        void onSuccessJson(RegisterBean registerBean);
        void onFailureJson(String msg);
    }
    //model层
    interface LoginModel{
        void login(String phone, String pwd, LoginCallBack loginCallBack);
        interface LoginCallBack{
            void onSuccessJson(RegisterBean registerBean);
            void onFailureJson(String msg);
        }
    }
    //presenter层
    interface LoginPresenter{
        void login(String phone, String pwd);
    }
}
