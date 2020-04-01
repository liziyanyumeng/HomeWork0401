package com.bawei.liziyan20200401.mvp;

import com.bawei.liziyan20200401.base.IBasePreesenter;
import com.bawei.liziyan20200401.bean.ShopCarBean;

public class ShopPresenter extends IBasePreesenter<ShopContract.ShopView> implements ShopContract.ShowPresenter {

    private ShopModel shopModel;

    @Override
    public void initModel() {
        shopModel = new ShopModel();
    }
    @Override
    public void shop() {
        shopModel.shopcar(new ShopContract.ShowModel.ShopCallBack() {
            @Override
            public void onSuccessJson(ShopCarBean shopCarBean) {
                view.onSuccessJson(shopCarBean);
            }
            @Override
            public void onFailureJson(String msg) {
                view.onFailureJson(msg);
            }
        });
    }
}
