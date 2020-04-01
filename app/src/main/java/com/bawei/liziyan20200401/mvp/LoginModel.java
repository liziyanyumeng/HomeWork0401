package com.bawei.liziyan20200401.mvp;

import com.bawei.liziyan20200401.bean.RegisterBean;
import com.bawei.liziyan20200401.util.ApiService;
import com.bawei.liziyan20200401.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginModel implements LoginContract.LoginModel {
    @Override
    public void login(String phone, String pwd, final LoginCallBack loginCallBack) {
        final RetrofitUtil instance = RetrofitUtil.getInstance();
        final ApiService apiService = instance.apiService();
        final Observable<RegisterBean> login = apiService.login(phone, pwd);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        loginCallBack.onSuccessJson(registerBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        loginCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
