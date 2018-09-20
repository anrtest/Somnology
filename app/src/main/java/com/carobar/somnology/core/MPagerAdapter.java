package com.carobar.somnology.core;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.carobar.somnology.Intro_TapTheOwl;
import com.carobar.somnology.R;

public class MPagerAdapter extends PagerAdapter {
    private int[] layouts;
    private LayoutInflater layoutInflater;
    private Context context;

    public MPagerAdapter(int[] layouts, Context context){
        this.layouts = layouts;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position){
        final View view = layoutInflater.inflate(layouts[position], container, false);

        if(position ==0){
            ImageView intro_owl = view.findViewById(R.id.intro1_owlIcon);
            TextView speechText = view.findViewById(R.id.introSpeechTxtView);
            startAnimation(intro_owl, speechText);
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    public void startAnimation(ImageView owl, TextView speechText){
        final ImageView imageOwl = owl;
        final TextView speechTextView = speechText;
        final Animation animation = AnimationUtils.loadAnimation(context, R.anim.bounce_object);
//        imageOwl.startAnimation(animation);
        Handler handlerImgOwl = new Handler();
        handlerImgOwl.postDelayed(new Runnable() {
            @Override
            public void run() {

                imageOwl.startAnimation(animation);
//                imageOwl.setImageAlpha(1);
//                if(Build.VERSION.SDK_INT > 15) {
//                    imageOwl.setImageAlpha(255);
//                }
//                else{
//                    imageOwl.setAlpha(1);
//                }

//                imageOwl.setVisibility(View.VISIBLE);
            }
        }, 100);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                speechTextView.startAnimation(animation);
//                speechTextView.setAlpha(1);
                //speechTextView.setVisibility(View.VISIBLE);
            }
        }, 350);
    }
}
