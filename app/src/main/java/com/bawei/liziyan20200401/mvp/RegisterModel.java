package com.bawei.liziyan20200401.mvp;

import com.bawei.liziyan20200401.bean.RegisterBean;
import com.bawei.liziyan20200401.util.ApiService;
import com.bawei.liziyan20200401.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterModel implements RegisterContract.RegisterModel {
    @Override
    public void register(String phone, String pwd, final RegisterCallBack registerCallBack) {
        final RetrofitUtil instance = RetrofitUtil.getInstance();
        final ApiService apiService = instance.apiService();
        final Observable<RegisterBean> register = apiService.register(phone, pwd);
        register.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        registerCallBack.onSuccessJson(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        registerCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}