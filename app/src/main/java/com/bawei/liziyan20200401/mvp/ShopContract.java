package com.bawei.liziyan20200401.mvp;

import com.bawei.liziyan20200401.base.IBaseView;
import com.bawei.liziyan20200401.bean.ShopCarBean;

public interface ShopContract {
    interface ShopView extends IBaseView{
        void onSuccessJson(ShopCarBean shopCarBean);
        void onFailureJson(String msg);
    }
    interface ShowModel{
        void shopcar(ShopCallBack shopCallBack);
        interface ShopCallBack{
            void onSuccessJson(ShopCarBean shopCarBean);
            void onFailureJson(String msg);
        }
    }
    interface ShowPresenter{
        void shop();
    }
}
