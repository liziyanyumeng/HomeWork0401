package com.bawei.liziyan20200401.mvp;

import com.bawei.liziyan20200401.base.IBaseView;
import com.bawei.liziyan20200401.bean.ShowBean;

public interface ShowContract {
    interface ShowView extends IBaseView {
        void onSuccessJson(ShowBean showBean);
        void onFailureJson(String msg);
    }
    interface ShowModel{
        void show(int page, int count, int status, ShowCallBack showCallBack);
        interface ShowCallBack{
            void onSuccessJson(ShowBean showBean);
            void onFailureJson(String msg);
        }
    }
    interface ShowPresenter{
        void show(int page, int count, int status);
    }
}
