package com.example.ken.test3;

import android.support.v4.app.Fragment;

/**
 * Created by Ken on 2017/12/17.
 */

public class MyFragment2 extends ExpandingFragment {

    public static MyFragment2 newInstance() {
        return new MyFragment2();
    }

    @Override
    protected Fragment getFragmentTop() {
        return null;
    }

    @Override
    protected Fragment getFragmentBottom() {
        return null;
    }
}

