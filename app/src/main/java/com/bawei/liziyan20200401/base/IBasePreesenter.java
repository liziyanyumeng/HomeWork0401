package com.bawei.liziyan20200401.base;

public abstract class IBasePreesenter<View> {
    public View view;

    public IBasePreesenter() {
        initModel();
    }

    public void attachView(View view){
        this.view = view;
    }
    public void detachView(){
        if (view != null) {
            view = null;
        }
    }
    public abstract void initModel();
}
