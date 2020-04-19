package com.devlopment.software.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewpagerFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList = new ArrayList<>();

    public ViewpagerFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public Fragment getItem(int i) {
        return mList.get(i);
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() :0;
    }
}
