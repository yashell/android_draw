package com.example.drawtest;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;

public class Revealeffect extends AppCompatActivity {

    boolean flag = false;
    private View iview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revealeffect);
        iview = findViewById(R.id.view_puppet);
    }

    public void doRevealAnimation(View view){
        int centerX =600;
        int centerY = 600;
        int height = iview.getHeight();
        int width = iview.getWidth();
        int maxRradius = (int) Math.hypot(height, width);
        if (height == 0) maxRradius = 1344;
        Log.d("第一次这个值会为空", maxRradius+"");
        if (flag) {
            Animator animator = ViewAnimationUtils.createCircularReveal(iview, centerX, centerY, maxRradius, 0);
            animator.setDuration(1000);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    iview.setVisibility(View.GONE); // 不可见 重新layout，不再占用空间 INVISIBLE 不重新layout
                }
            });
            animator.start();
            flag = false;
        } else {
            Animator animator = ViewAnimationUtils.createCircularReveal(iview, centerX, centerY, 0, maxRradius);
            animator.setDuration(1000);
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    iview.setVisibility(View.VISIBLE);
                }
                @Override
                public void onAnimationEnd(Animator animation) {
                }
                @Override
                public void onAnimationCancel(Animator animation) {
                }
                @Override
                public void onAnimationRepeat(Animator animation) {
                }
            });
            animator.start();
            flag = true;
        }
    }
}
