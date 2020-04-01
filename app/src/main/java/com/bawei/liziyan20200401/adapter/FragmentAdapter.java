package com.bawei.liziyan20200401.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bawei.liziyan20200401.fragment.Fragment_main;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentPagerAdapter {
    public ArrayList<Fragment_main> arrayList = new ArrayList<>();
    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
        arrayList.add(new Fragment_main());
        arrayList.add(new Fragment_main());
        arrayList.add(new Fragment_main());
        arrayList.add(new Fragment_main());
        arrayList.add(new Fragment_main());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "全部订单";
            case 1:
                return "待付款";
            case 2:
                return "待收货";
            case 3:
                return "待评价";
            case 4:
                return "已完成";
        }
        return "全部订单";
    }
}
