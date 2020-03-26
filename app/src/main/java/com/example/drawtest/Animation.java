package com.example.drawtest;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class Animation extends AppCompatActivity {
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        img = (ImageView) findViewById(R.id.img);
    }

    public void an_translate(View v) {
//        android.view.animation.Animation translateAnimation = new TranslateAnimation(0,500,0,500);
//        // 创建平移动画的对象：平移动画对应的Animation子类为TranslateAnimation
//        // 参数分别是：
//        // 1. fromXDelta ：视图在水平方向x 移动的起始值
//        // 2. toXDelta ：视图在水平方向x 移动的结束值
//        // 3. fromYDelta ：视图在竖直方向y 移动的起始值
//        // 4. toYDelta：视图在竖直方向y 移动的结束值
//        translateAnimation.setDuration(3000);
//        translateAnimation.setFillAfter(true); // 留在最终的位置
//        // 播放动画直接 startAnimation(translateAnimation)
//        //如：
//        img.startAnimation(translateAnimation);

        //属性动画
        ObjectAnimator animator = ObjectAnimator.ofFloat(img, "TranslationX", 0, 500);
        animator.setDuration(3000);
        animator.setRepeatCount(-1); // 循环次数
        //animator.setRepeatMode(ValueAnimator.RESTART); // 从头开始循环
        animator.setRepeatMode(ValueAnimator.REVERSE); // 从上次结束的位置 回到开始位置循环
        animator.start();
        animator.pause();
    }

    public void an_scale(View v) {
//        android.view.animation.Animation rotateAnimation = new ScaleAnimation(0,2,0,2, android.view.animation.Animation.RELATIVE_TO_SELF,0.5f, android.view.animation.Animation.RELATIVE_TO_SELF,0.5f);
//        // 创建缩放动画的对象 & 设置动画效果：缩放动画对应的Animation子类为RotateAnimation
//        // 参数说明:
//        // 1. fromX ：动画在水平方向X的结束缩放倍数
//        // 2. toX ：动画在水平方向X的结束缩放倍数
//        // 3. fromY ：动画开始前在竖直方向Y的起始缩放倍数
//        // 4. toY：动画在竖直方向Y的结束缩放倍数
//        // 5. pivotXType:缩放轴点的x坐标的模式
//        // 6. pivotXValue:缩放轴点x坐标的相对值
//        // 7. pivotYType:缩放轴点的y坐标的模式
//        // 8. pivotYValue:缩放轴点y坐标的相对值
//        // pivotXType = Animation.ABSOLUTE:缩放轴点的x坐标 =  View左上角的原点 在x方向 加上 pivotXValue数值的点(y方向同理)
//        // pivotXType = Animation.RELATIVE_TO_SELF:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 自身宽度乘上pivotXValue数值的值(y方向同理)
//        // pivotXType = Animation.RELATIVE_TO_PARENT:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 父控件宽度乘上pivotXValue数值的值 (y方向同理)
//        rotateAnimation.setDuration(3000);
//        // 固定属性的设置都是在其属性前加“set”，如setDuration（）
//        img.startAnimation(rotateAnimation);

//        // 属性动画-ValueAnimator
//        //不改变属性大小，只在一段事件内生成连续的值
//        ValueAnimator animator = ValueAnimator.ofFloat(0f, 200f);
//        animator.setDuration(500);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                //百分比对应的值
//                float value = (float) animation.getAnimatedValue();
//                Log.e("TAG", "onAnimationUpdate: " + value);
//                img.setScaleX(0.5f + value / 200);
//                img.setScaleY(0.5f + value / 200);
//            }
//        });
//        animator.start();

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(img, "translationX", 0f, 100f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(img, "alpha", 0f, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(img, "scaleX", 0f, 1f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        //动画1，2同时执行
        animatorSet.play(animator1).with(animator2);
        //动画2执行完成后执行动画3
        animatorSet.play(animator3).after(animator2);
        animatorSet.start();


//        // 属性动画-ObjectAnimator
//        AnimatorSet animatorSetPeople = new AnimatorSet();  //多个动画 动画集
//        animatorSetPeople.setDuration(1000);
//        ObjectAnimator translationX = ObjectAnimator.ofFloat(img, "translationX", -110, 110, 0);
//        ObjectAnimator scaleX = ObjectAnimator.ofFloat(img, "scaleX", 1, 2, 1);//从原始状态放大2倍再回到原始状态
//        ObjectAnimator scaleY = ObjectAnimator.ofFloat(img, "scaleY", 1, 2, 1);
//        translationX.setRepeatCount(-1);//设置动画重复次数
//        translationX.setRepeatMode(ObjectAnimator.RESTART);//动画重复模式
//        translationX.setStartDelay(1000);//动画延时执行
//        translationX.setInterpolator(new AccelerateInterpolator());//Interpolator可以定义动画播放的速度
//        /*after(Animator anim) 将现有动画插入到传入的动画之后执行
//after(long delay) 将现有动画延迟指定毫秒后执行
//before(Animator anim) 将现有动画插入到传入的动画之前执行
//with(Animator anim) 将现有动画和传入的动画同时执行*/
//        animatorSetPeople.play(translationX).before(scaleX).before(scaleY);
//        // animatorSetPeople.playTogether(translationX, scaleX, scaleY);
//        animatorSetPeople.start();
//        animatorSetPeople.end();
//        animatorSetPeople.cancel();

    }

    public void an_rotate(View v) {
//        android.view.animation.Animation rotateAnimation = new RotateAnimation(0,270, android.view.animation.Animation.RELATIVE_TO_SELF,0.5f, android.view.animation.Animation.RELATIVE_TO_SELF,0.5f);
//        // 创建旋转动画的对象 & 设置动画效果：旋转动画对应的Animation子类为RotateAnimation
//        // 参数说明:
//        // 1. fromDegrees ：动画开始时 视图的旋转角度(正数 = 顺时针，负数 = 逆时针)
//        // 2. toDegrees ：动画结束时 视图的旋转角度(正数 = 顺时针，负数 = 逆时针)
//        // 3. pivotXType：旋转轴点的x坐标的模式
//        // 4. pivotXValue：旋转轴点x坐标的相对值
//        // 5. pivotYType：旋转轴点的y坐标的模式
//        // 6. pivotYValue：旋转轴点y坐标的相对值
//
//        // pivotXType = Animation.ABSOLUTE:旋转轴点的x坐标 =  View左上角的原点 在x方向 加上 pivotXValue数值的点(y方向同理)
//        // pivotXType = Animation.RELATIVE_TO_SELF:旋转轴点的x坐标 = View左上角的原点 在x方向 加上 自身宽度乘上pivotXValue数值的值(y方向同理)
//        // pivotXType = Animation.RELATIVE_TO_PARENT:旋转轴点的x坐标 = View左上角的原点 在x方向 加上 父控件宽度乘上pivotXValue数值的值 (y方向同理)
//
//
//        rotateAnimation.setDuration(3000);
//        // 固定属性的设置都是在其属性前加“set”，如setDuration（）
//
//        img.startAnimation(rotateAnimation);
//        // 步骤3：播放动画

        // 属性动画 - ObjectAnimator
        ObjectAnimator rotation = ObjectAnimator.ofFloat(img, "Rotation", 0, 180);
        rotation.setRepeatCount(-1);//无限循环
        rotation.setRepeatMode(ValueAnimator.REVERSE);
        rotation.setDuration(2000);
        rotation.start();
    }

    public void an_alpha(View v) {
//        android.view.animation.Animation alphaAnimation = new AlphaAnimation(1,0);
//        // 步骤2：创建透明度动画的对象 & 设置动画效果：透明度动画对应的Animation子类为AlphaAnimation
//        // 参数说明:
//        // 1. fromAlpha:动画开始时视图的透明度(取值范围: -1 ~ 1)
//        // 2. toAlpha:动画结束时视图的透明度(取值范围: -1 ~ 1)
//
//
//        alphaAnimation.setDuration(3000);
//        // 固定属性的设置都是在其属性前加“set”，如setDuration（）
//
//        img.startAnimation(alphaAnimation);

        // 属性动画
        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(img, "alpha", 1.0f, 0.0f);
        //执行事件
        alphaAnim.setDuration(1000);
        //延迟
        alphaAnim.setStartDelay(300);
        alphaAnim.start();



    }
    public void an_compose(View v) {
        AnimationSet setAnimation = new AnimationSet(true);
        // 步骤1:创建组合动画对象(设置为true)


        // 步骤2:设置组合动画的属性
        // 特别说明以下情况
        // 因为在下面的旋转动画设置了无限循环(RepeatCount = INFINITE)
        // 所以动画不会结束，而是无限循环
        // 所以组合动画的下面两行设置是无效的
        setAnimation.setRepeatMode(android.view.animation.Animation.RESTART);
        setAnimation.setRepeatCount(1);// 设置了循环一次,但无效

        // 步骤3:逐个创建子动画(方式同单个动画创建方式,此处不作过多描述)

        // 子动画1:旋转动画
        android.view.animation.Animation rotate = new RotateAnimation(0,360, android.view.animation.Animation.RELATIVE_TO_SELF,0.5f, android.view.animation.Animation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(1000);
        rotate.setRepeatMode(android.view.animation.Animation.RESTART);
        rotate.setRepeatCount(android.view.animation.Animation.INFINITE);

        // 子动画2:平移动画
        android.view.animation.Animation translate = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT,0f,
                TranslateAnimation.RELATIVE_TO_PARENT,0.5f,
                TranslateAnimation.RELATIVE_TO_SELF,0
                ,TranslateAnimation.RELATIVE_TO_SELF,0);
        translate.setDuration(10000);

        // 子动画3:透明度动画
        android.view.animation.Animation alpha = new AlphaAnimation(1,0);
        alpha.setDuration(3000);
        alpha.setStartOffset(7000);

        // 子动画4:缩放动画
        android.view.animation.Animation scale1 = new ScaleAnimation(1,0.5f,1,0.5f, android.view.animation.Animation.RELATIVE_TO_SELF,0.5f, android.view.animation.Animation.RELATIVE_TO_SELF,0.5f);
        scale1.setDuration(1000);
        scale1.setStartOffset(4000);

        // 步骤4:将创建的子动画添加到组合动画里
        setAnimation.addAnimation(alpha);
        setAnimation.addAnimation(rotate);
        setAnimation.addAnimation(translate);
        setAnimation.addAnimation(scale1);

        img.startAnimation(setAnimation);
    }

}
