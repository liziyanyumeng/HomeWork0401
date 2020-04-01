package com.bawei.liziyan20200401.mvp;

import com.bawei.liziyan20200401.bean.ShowBean;
import com.bawei.liziyan20200401.util.ApiService;
import com.bawei.liziyan20200401.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ShowModel implements ShowContract.ShowModel {
    @Override
    public void show(int page, int count, int status, final ShowCallBack showCallBack) {
        final RetrofitUtil instance = RetrofitUtil.getInstance();
        final ApiService apiService = instance.apiService();
        final Observable<ShowBean> show = apiService.show(page, count, status);
        show.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(ShowBean showBean) {
                        showCallBack.onSuccessJson(showBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        showCallBack.onFailureJson(e.getMessage());
                    }
                    @Override
                    public void onComplete() {}
                });
    }
}
