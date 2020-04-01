package com.bawei.liziyan20200401.mvp;

import com.bawei.liziyan20200401.base.IBasePreesenter;
import com.bawei.liziyan20200401.bean.ShowBean;

public class ShowPresenter extends IBasePreesenter<ShowContract.ShowView> implements ShowContract.ShowPresenter {

    private ShowModel showModel;

    @Override
    public void initModel() {
        showModel = new ShowModel();
    }

    @Override
    public void show(int page, int count, int status) {
        showModel.show(page, count, status, new ShowContract.ShowModel.ShowCallBack() {
            @Override
            public void onSuccessJson(ShowBean showBean) {
                view.onSuccessJson(showBean);
            }

            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}