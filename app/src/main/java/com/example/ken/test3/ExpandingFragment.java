package com.example.ken.test3;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ken on 2017/12/17.
 */

public abstract class ExpandingFragment extends android.support.v4.app.Fragment{
    private static final float SCALE_OPENED = 1.1f;
    private static final float SCALE_OPENED2 = 1.4f;
    private static final float Move_OPENED = -150f;
    private android.support.v4.app.Fragment fragmentFront;
    private android.support.v4.app.Fragment fragmentBottom;
    private Boolean isClosed = true;
    private Boolean isClick = false;
    private CardView back;
    private CardView front;
    ObjectAnimator fopenX,fopenY,fmoveY;
    ObjectAnimator bopenX,bopenY;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.expanding_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        this.fragmentFront = getFragmentTop();
        this.fragmentBottom = getFragmentBottom();

        if (fragmentFront != null && fragmentBottom != null){
            getChildFragmentManager().beginTransaction().replace(R.id.front,fragmentFront)
                    .replace(R.id.back,fragmentBottom).commit();
        }

        back = view.findViewById(R.id.back);
        front = view.findViewById(R.id.front);


        //前界面动画
        front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isClosed){
                    fopenX = ObjectAnimator.ofFloat(front,"scaleX",1.0f,SCALE_OPENED);
                    fopenY = ObjectAnimator.ofFloat(front,"scaleY",1.0f,SCALE_OPENED);
                    fmoveY = ObjectAnimator.ofFloat(front,"translationY",0.0f,Move_OPENED);
                    bopenX = ObjectAnimator.ofFloat(back,"scaleX",1.0f,SCALE_OPENED2);
                    bopenY = ObjectAnimator.ofFloat(back,"scaleY",1.0f,SCALE_OPENED2);
                    AnimatorSet set = new AnimatorSet();
                    set.setDuration(1000);
                    set.playTogether(fopenX,fopenY,fmoveY,bopenX,bopenY);
                    set.start();
                    isClick = true;
                }else if(isClick){
                    startActivity(new Intent(getContext(),Main2Activity.class));
                } else{
                    return;
                }
                isClosed = false;
            }
        });
        //后界面动画
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fopenX = ObjectAnimator.ofFloat(front,"scaleX",SCALE_OPENED,1.0f);
                fopenY = ObjectAnimator.ofFloat(front,"scaleY",SCALE_OPENED,1.0f);
                fmoveY = ObjectAnimator.ofFloat(front,"translationY",Move_OPENED,0.0f);
                bopenX = ObjectAnimator.ofFloat(back,"scaleX",SCALE_OPENED2,1.0f);
                bopenY = ObjectAnimator.ofFloat(back,"scaleY",SCALE_OPENED2,1.0f);
                AnimatorSet set = new AnimatorSet();
                set.setDuration(1000);
                set.playTogether(fopenX,fopenY,fmoveY,bopenY,bopenX);
                set.start();
                isClosed = true;
            }
        });
    }

    public abstract Fragment getFragmentTop();

    public abstract Fragment getFragmentBottom();

    public  Boolean getClosed() {
        return isClosed;
    }

    public   Boolean getClick() {
        return isClick;
    }

    public void backPress(){
        if(!isClosed){
            fopenX = ObjectAnimator.ofFloat(front,"scaleX",SCALE_OPENED,1.0f);
            fopenY = ObjectAnimator.ofFloat(front,"scaleY",SCALE_OPENED,1.0f);
            fmoveY = ObjectAnimator.ofFloat(front,"translationY",Move_OPENED,0.0f);
            bopenX = ObjectAnimator.ofFloat(back,"scaleX",SCALE_OPENED2,1.0f);
            bopenY = ObjectAnimator.ofFloat(back,"scaleY",SCALE_OPENED2,1.0f);
            AnimatorSet set = new AnimatorSet();
            set.setDuration(1000);
            set.playTogether(fopenX,fopenY,fmoveY,bopenY,bopenX);
            set.start();
            isClosed = true;
        }

      }


}
