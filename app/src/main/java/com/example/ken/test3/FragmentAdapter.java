package com.example.ken.test3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Ken on 2017/12/17.
 */

public class FragmentAdapter extends FragmentPagerAdapter{

    private List<ExpandingFragment> fragmentList;

    FragmentAdapter(FragmentManager fm, List<ExpandingFragment> list) {
        super(fm);
        this.fragmentList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}