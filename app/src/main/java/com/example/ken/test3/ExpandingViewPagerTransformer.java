package com.example.ken.test3;

import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Ken on 2017/12/17.
 */

public class ExpandingViewPagerTransformer implements ViewPager.PageTransformer {

    public static final float MAX_SCALE = 0.9f;
    public static final float MIN_SCALE = 0.8f;

    @Override
    public void transformPage(View page, float position) {

        position = position < -1 ? -1 : position;
        position = position > 1 ? 1 : position;

        float tempScale = position < 0 ? 1 + position : 1 - position;

        float slope = (MAX_SCALE - MIN_SCALE) / 1;
        float scaleValue = MIN_SCALE + tempScale * slope;
        page.setScaleX(scaleValue);
        page.setScaleY(scaleValue);
    }
}
