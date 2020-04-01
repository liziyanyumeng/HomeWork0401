package com.bawei.liziyan20200401.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.liziyan20200401.R;
import com.bawei.liziyan20200401.adapter.WaiAdapter;
import com.bawei.liziyan20200401.base.BaseFragment;
import com.bawei.liziyan20200401.bean.OrderList;
import com.bawei.liziyan20200401.bean.ShowBean;
import com.bawei.liziyan20200401.mvp.ShowContract;
import com.bawei.liziyan20200401.mvp.ShowPresenter;

import java.util.ArrayList;

public class Fragment_main extends BaseFragment<ShowPresenter> implements ShowContract.ShowView {

    private RecyclerView racyclerFragment;
    private WaiAdapter waiAdapter;

    @Override
    public int initLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public ShowPresenter initModel() {
        return new ShowPresenter();
    }

    @Override
    public void initView(View inflate) {
        racyclerFragment = (RecyclerView) inflate.findViewById(R.id.racycler_fragment);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        racyclerFragment.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void initListener() {}
    @Override
    public void initData() {
        f.show(1,10,0);
    }

    @Override
    public void onSuccessJson(ShowBean showBean) {
        final ArrayList<OrderList> orderList = showBean.orderList;
        waiAdapter = new WaiAdapter(getContext(),orderList);
        racyclerFragment.setAdapter(waiAdapter);
    }

    @Override
    public void onFailureJson(String msg) {

    }
}
