package com.bawei.liziyan20200401.mvp;

import com.bawei.liziyan20200401.bean.ShopCarBean;
import com.bawei.liziyan20200401.util.ApiService;
import com.bawei.liziyan20200401.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ShopModel implements ShopContract.ShowModel {
    @Override
    public void shopcar(final ShopCallBack shopCallBack) {
        final RetrofitUtil instance = RetrofitUtil.getInstance();
        final ApiService apiService = instance.apiService();
        final Observable<ShopCarBean> shopcar = apiService.shopcar();
        shopcar.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopCarBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(ShopCarBean shopCarBean) {
                        shopCallBack.onSuccessJson(shopCarBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        shopCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
