package com.shusheng1978.yushuliang.learnview20150821;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by yushuliang on 15/8/24.
 */
public class PrivateAnimation extends Animation {

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

//        System.out.println(interpolatedTime);
//        t.setAlpha(interpolatedTime); //透明重0-1
//        t.getMatrix().setTranslate(100*interpolatedTime, 100*interpolatedTime);  //移动位置
//        t.getMatrix().setTranslate((float) Math.sin(interpolatedTime*10)*50, 0); //左右摇头
        t.getMatrix().setTranslate(0, (float) Math.sin(interpolatedTime*10)*50); //上下摇摆，两个同时加载时后面的那个动作

        super.applyTransformation(interpolatedTime, t);
    }
}
