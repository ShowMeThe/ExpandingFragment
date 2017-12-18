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
    public Fragment getFragmentTop() {
        return Fragment1Top.newInstance();
    }

    @Override
    public Fragment getFragmentBottom() {
        return Fragment1Bottom.newInstance();
    }


    public static class Fragment1Top extends Fragment{
        public static volatile Fragment1Top top = null;
        public static Fragment1Top newInstance() {
            if(top == null){
                synchronized (Fragment1Top.class){
                    if(top == null){
                        top = new Fragment1Top();
                    }
                }
            }
            return top;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment1_top, container, false);
        }
    }

    public static class Fragment1Bottom extends Fragment{
        public  static volatile Fragment1Bottom bottom = null;
        public  static Fragment1Bottom newInstance() {
            if(bottom == null){
                synchronized (Fragment1Bottom.class){
                    if(bottom == null){
                        bottom = new Fragment1Bottom();
                    }
                }
            }
            return bottom;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment1_bottom, container, false);
        }
    }
}
