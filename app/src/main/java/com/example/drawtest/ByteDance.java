package com.example.drawtest;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ByteDance extends AppCompatActivity {

    private TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_byte_dance);

        text1 = (TextView) findViewById(R.id.Text1);

    }
    public void tvTimer(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        text1.setText(
                                (Integer) animation.getAnimatedValue());
                    }
                });
        valueAnimator.setDuration(3000);
        valueAnimator.start();

    }
}
