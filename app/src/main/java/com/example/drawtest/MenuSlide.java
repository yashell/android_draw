package com.example.drawtest;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuSlide extends AppCompatActivity {
    private int[] mRes = {R.id.imageView_a, R.id.imageView_b, R.id.imageView_c,
            R.id.imageView_d, R.id.imageView_e};
    private List<ImageView> mImageViews = new ArrayList<ImageView>();
    private boolean mFlag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_slide);
        for (int i = 0; i < mRes.length; i++) {
            ImageView imageView = (ImageView) findViewById(mRes[i]);
            mImageViews.add(imageView);
        }
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_a:
                if (mFlag) {
                    startAnim();
                } else {
                    closeAnim();
                }
                break;
            default:
                Toast.makeText(MenuSlide.this, "" + v.getId(),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void closeAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(mImageViews.get(0),
                "alpha", 0.5F, 1F);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageViews.get(1),
                "translationY", 200F, 0);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageViews.get(2),
                "translationX", 200F, 0);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImageViews.get(3),
                "translationY", -200F, 0);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImageViews.get(4),
                "translationX", -200F, 0);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator0, animator1, animator2, animator3, animator4);
        set.start();
        mFlag = true;
    }
    private void startAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(
                mImageViews.get(0),
                "alpha",
                1F,
                0.2F);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                mImageViews.get(1),
                "translationY",
                100F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                mImageViews.get(2),
                "translationX",
                100F);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(
                mImageViews.get(3),
                "translationY",
                -100F);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(
                mImageViews.get(4),
                "translationX",
                -100F);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(
                animator0,
                animator1,
                animator2,
                animator3,
                animator4);
        set.start();
        mFlag = false;
    }
}
