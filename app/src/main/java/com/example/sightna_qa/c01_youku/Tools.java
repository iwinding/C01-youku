package com.example.sightna_qa.c01_youku;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;

/**
 * Created by Sightna-QA on 2016/1/6.
 */
public class Tools {
//    public static void hideView(View view) {
//        RotateAnimation ra = new RotateAnimation(0, 180, view.getWidth() / 2, view.getHeight());
//        ra.setDuration(500);
//        ra.setFillAfter(true);
//        view.startAnimation(ra);
//
//    }
//    public static void hideView(View view,int i) {
//        RotateAnimation ra = new RotateAnimation(0, 180, view.getWidth() / 2, view.getHeight());
//        ra.setDuration(500);
//        ra.setFillAfter(true);
//        ra.setStartOffset(i);
//
//        view.startAnimation(ra);
//
//    }
//    public static void showView(View view) {
//        RotateAnimation ra = new RotateAnimation(180, 360, view.getWidth() / 2, view.getHeight());
//        ra.setDuration(500);
//        ra.setFillAfter(true);
//        view.startAnimation(ra);
//    }
//    public static void showView(View view,int i) {
//        RotateAnimation ra = new RotateAnimation(180, 360, view.getWidth() / 2, view.getHeight());
//        ra.setDuration(500);
//        ra.setFillAfter(true);
//        ra.setStartOffset(i);
//
//        view.startAnimation(ra);
//    }

    public static void hideView(ViewGroup view) {
        hideView(view,0);
    }


    public static void showView(ViewGroup view) {
        showView(view,0);
    }

    public static void hideView(ViewGroup view, int offset) {
        RotateAnimation ra = new RotateAnimation(0, 180, view.getWidth() / 2, view.getHeight());
        ra.setDuration(500);
        ra.setFillAfter(true);
        ra.setStartOffset(offset);
        view.startAnimation(ra);


        for (int i=0; i < view.getChildCount(); i++) {
            View childAt = view.getChildAt(i);
            childAt.setVisibility(View.GONE);

        }

    }
    public static void showView(ViewGroup view,int offset) {
        view.setVisibility(view.VISIBLE);
        RotateAnimation ra = new RotateAnimation(180, 360, view.getWidth() / 2, view.getHeight());
        ra.setDuration(500);
        ra.setFillAfter(true);
        ra.setStartOffset(offset);
        view.startAnimation(ra);
        for (int i = 0; i < view.getChildCount(); i++) {
            View childAt = view.getChildAt(i);
            childAt.setVisibility(view.VISIBLE);
        }
    }
}
