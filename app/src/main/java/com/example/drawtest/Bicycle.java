package com.example.drawtest;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

public class Bicycle extends AppCompatActivity {

    private RelativeLayout bicycle_before;
    private RelativeLayout bicycle_after;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicycle);

        bicycle_after = (RelativeLayout) findViewById(R.id.bicycle_after);
        bicycle_before = (RelativeLayout) findViewById(R.id.bicycle_before);

        an_rotate();
    }


    public void an_rotate() {
        AnimationSet setAnimation = new AnimationSet(true);

        setAnimation.setInterpolator(new LinearInterpolator());
        // 步骤1:创建组合动画对象(设置为true)

        // 子动画1:旋转动画
        android.view.animation.Animation rotate = new RotateAnimation(0,360, android.view.animation.Animation.RELATIVE_TO_SELF,0.5f, android.view.animation.Animation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(10000);
        rotate.setRepeatMode(android.view.animation.Animation.RESTART);
        rotate.setRepeatCount(android.view.animation.Animation.INFINITE);


        // 步骤4:将创建的子动画添加到组合动画里
        setAnimation.addAnimation(rotate);



        bicycle_after.startAnimation(setAnimation);
        bicycle_before.startAnimation(setAnimation);




        // 步骤3：播放动画
    }


}
