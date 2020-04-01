package com.bawei.liziyan20200401;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.liziyan20200401.adapter.FragmentAdapter;
import com.bawei.liziyan20200401.base.BaseActivity;
import com.bawei.liziyan20200401.bean.ShowBean;
import com.bawei.liziyan20200401.mvp.ShowContract;
import com.bawei.liziyan20200401.mvp.ShowPresenter;
import com.bawei.liziyan20200401.util.ImageUtil;
import com.bawei.liziyan20200401.util.SpUtil;
import com.google.android.material.tabs.TabLayout;

public class ShowActivity extends BaseActivity<ShowPresenter>{

    private android.widget.ImageView showImage;
    private android.widget.TextView showPhone;
    private com.google.android.material.tabs.TabLayout tablayout;
    private androidx.viewpager.widget.ViewPager viewpager;
    private FragmentAdapter fragmentAdapter;

    @Override
    public int initLayoutId() {
        return R.layout.activity_show;
    }

    @Override
    public ShowPresenter initModel() {
        return new ShowPresenter();
    }

    @Override
    public void initView() {
        showImage = (ImageView) findViewById(R.id.show_image);
        showPhone = (TextView) findViewById(R.id.show_phone);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        final String nickName = SpUtil.getString("nickName");
        final String headPic = SpUtil.getString("headPic");
        showPhone.setText("用户名:"+nickName);
        final ImageUtil instance = ImageUtil.getInstance();
        instance.getPictore(headPic,showImage);
        tablayout.setupWithViewPager(viewpager);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewpager.setAdapter(fragmentAdapter);
    }

}
