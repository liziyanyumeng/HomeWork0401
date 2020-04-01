package com.bawei.liziyan20200401;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.liziyan20200401.adapter.AllAdapter;
import com.bawei.liziyan20200401.base.BaseActivity;
import com.bawei.liziyan20200401.bean.ResultBean;
import com.bawei.liziyan20200401.bean.ShopCarBean;
import com.bawei.liziyan20200401.mvp.ShopContract;
import com.bawei.liziyan20200401.mvp.ShopPresenter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<ShopPresenter> implements ShopContract.ShopView {

    private androidx.recyclerview.widget.RecyclerView recycler;
    private AllAdapter allAdapter;

    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public ShopPresenter initModel() {
        return new ShopPresenter();
    }

    @Override
    public void initView() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void initListener() {}

    @Override
    public void initData() {
        p.shop();
    }

    @Override
    public void onSuccessJson(ShopCarBean shopCarBean) {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        final ArrayList<ResultBean> result = shopCarBean.result;
        allAdapter = new AllAdapter(MainActivity.this,result);
        recycler.setAdapter(allAdapter);
    }

    @Override
    public void onFailureJson(String msg) {
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
    }
}
