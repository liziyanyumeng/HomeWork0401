package com.bawei.liziyan20200401.mvp;


import com.bawei.liziyan20200401.base.IBaseView;
import com.bawei.liziyan20200401.bean.RegisterBean;

public interface RegisterContract {
    interface RegisterView extends IBaseView {
        void onSuccessJson(RegisterBean registerBean);
        void onFailureJson(String msg);
    }
    //model层
    interface RegisterModel{
        void register(String phone, String pwd, RegisterCallBack registerCallBack);
        interface RegisterCallBack{
            void onSuccessJson(RegisterBean registerBean);
            void onFailureJson(String msg);
        }
    }
    //presenter层
    interface RegisterPresenter{
        void register(String phone, String pwd);
    }
}
