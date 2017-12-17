package com.example.ken.test3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    private List<ExpandingFragment> fragmentList = new ArrayList<>();
    private FragmentPagerAdapter adapter;
    private MyFragment fragment = MyFragment.newInstance();
    private MyFragment2 fragment2 = MyFragment2.newInstance();
    private MyFragment3 fragment3 = MyFragment3.newInstance();
    private  ExpandingFragment currentFrament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         if(getSupportActionBar()!= null){
          getSupportActionBar().hide();
         }
         //获取屏幕高度
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;

        //添加fragment到List
        fragmentList.add(fragment);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);

        viewPager = findViewById(R.id.viewPage);
        adapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);

        viewPager.setPageTransformer(true, new ExpandingViewPagerTransformer());
        //设置page的间距，ViewPage设置 android:clipChildren="false"
        viewPager.setPageMargin(-width/2);
        viewPager.setOffscreenPageLimit(3);

        //监听操作
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                currentFrament = fragmentList.get(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    public void onBackPressed(){
        currentFrament.backPress();
    }
}
