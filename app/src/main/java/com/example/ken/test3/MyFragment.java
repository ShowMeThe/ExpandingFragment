package com.example.ken.test3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ken on 2017/12/17.
 */

public class MyFragment extends ExpandingFragment {

    public static MyFragment newInstance() {
        return new MyFragment();
    }

    @Override
    protected Fragment getFragmentTop() {
        return Fragment1Top.newInstance();
    }

    @Override
    protected Fragment getFragmentBottom() {
        return Fragment1Bottom.newInstance();
    }


    @SuppressLint("ValidFragment")
    public static class Fragment1Top extends Fragment{
        public static Fragment1Top newInstance() {
            return new Fragment1Top();
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment1_top, container, false);
        }
    }

    @SuppressLint("ValidFragment")
    public static class Fragment1Bottom extends Fragment{
        public static Fragment1Bottom newInstance() {
            return new Fragment1Bottom();
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment1_bottom, container, false);
        }
    }
}
