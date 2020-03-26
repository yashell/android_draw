package com.example.drawtest;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Dazzle extends AppCompatActivity {
    private LinearLayout dazzle_main_1;
    private LinearLayout dazzle_main_2;
    private LinearLayout flow_1;
    private LinearLayout flow_2;
    private int step = 0;
//    private ImageView flow_1;
//    private ImageView flow_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dazzle);
        flow_1 = (LinearLayout) findViewById(R.id.flow_1);
        flow_2 = (LinearLayout) findViewById(R.id.flow_2);

        dazzle_main_1 = (LinearLayout) findViewById(R.id.dazzle_main_1);
        dazzle_main_2 = (LinearLayout) findViewById(R.id.dazzle_main_2);

//        flow_1 = (ImageView) findViewById(R.id.flow_1);
//        flow_2 = (ImageView) findViewById(R.id.flow_2);
    }
    public void flow_1_click (View view) {
        Animation translateAnimation;
        Animation translateAnimation2;
        AnimatorSet mAnimatorSet = null;

        // 属性动画
        AnimatorSet animatorSet = new AnimatorSet();
        switch (step){
            case 0:
//                translateAnimation = new TranslateAnimation(0,0,0,-3700);
//                translateAnimation.setDuration(1000);
//                translateAnimation.setFillAfter(true); // 留在最终的位置
//                flow_1.startAnimation(translateAnimation);
//                flow_2.startAnimation(translateAnimation);
//                dazzle_main_1.startAnimation(translateAnimation);
//                dazzle_main_2.startAnimation(translateAnimation);

                ObjectAnimator animatorA_0 = ObjectAnimator.ofFloat(flow_1, "translationY", 0f, -3700f);
                ObjectAnimator animatorA_1 = ObjectAnimator.ofFloat(flow_2, "translationY", 0f, -3700f);
                ObjectAnimator animatorA_2 = ObjectAnimator.ofFloat(dazzle_main_1, "translationY", 0f, -3700f);
                ObjectAnimator animatorA_3 = ObjectAnimator.ofFloat(dazzle_main_1, "translationY", 0f, -3700f);
                animatorSet.setDuration(1000);
                animatorSet.play(animatorA_0).with(animatorA_1).with(animatorA_2).with(animatorA_3);
                animatorSet.start();


                break;
            case 1:

                ObjectAnimator animatorB_0 = ObjectAnimator.ofFloat(flow_1, "translationY", -3700f, -6500f);
                ObjectAnimator animatorB_1 = ObjectAnimator.ofFloat(flow_2, "translationY", -3700f, -6500f);
                ObjectAnimator animatorB_2 = ObjectAnimator.ofFloat(dazzle_main_1, "translationY", -3700f, -6500f);
                ObjectAnimator animatorB_3 = ObjectAnimator.ofFloat(dazzle_main_1, "translationY", -3700f, -6500f);
                animatorSet.setDuration(1000);
                animatorSet.play(animatorB_0).with(animatorB_1).with(animatorB_2).with(animatorB_3);
                animatorSet.start();

//
//                ObjectAnimator animator1 = ObjectAnimator.ofFloat(flow_1, "translationY", -3700f, -6500f);
////                ObjectAnimator animator2 = ObjectAnimator.ofFloat(img, "alpha", 0f, 1f);
//
//
//
//                //动画1，2同时执行
////                animatorSet.play(animator1).with(animator2);
//                animatorSet.play(animator1);
//                //动画2执行完成后执行动画3
////                animatorSet.play(animator3).after(animator2);
//                animatorSet.start();
//
//                translateAnimation = new TranslateAnimation(0,0,-3700,-6500);
//                translateAnimation.setDuration(1000);
//                translateAnimation.setFillAfter(true); // 留在最终的位置
//                flow_1.startAnimation(translateAnimation);
//                flow_2.startAnimation(translateAnimation);
//                dazzle_main_1.startAnimation(translateAnimation);
//                dazzle_main_2.startAnimation(translateAnimation);
//
//                translateAnimation2 = new TranslateAnimation(0,1000,-6500,-6500);
//                translateAnimation2.setDuration(1000);
//                translateAnimation2.setFillAfter(true); // 留在最终的位置
//                flow_1.startAnimation(translateAnimation2);
//                flow_2.startAnimation(translateAnimation2);
//                dazzle_main_1.startAnimation(translateAnimation2);
//                dazzle_main_2.startAnimation(translateAnimation2);

                break;


        }
        Log.d("现在是第几步了：", step+ "");
        step ++;
        if (step == 2) step = 0;


    }

}
