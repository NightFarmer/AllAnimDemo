package com.nightfarmer.allanimdemo;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class PropertyAnimationActivity extends AppCompatActivity {

    Button bt_1;
    Button bt_2;
    Button bt_3;
    Button bt_4;
    Button bt_5;
    Button bt_6;
    Button bt_7;
    Button bt_8;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        bt_1 = (Button) findViewById(R.id.bt_1);
        bt_2 = (Button) findViewById(R.id.bt_2);
        bt_3 = (Button) findViewById(R.id.bt_3);
        bt_4 = (Button) findViewById(R.id.bt_4);
        bt_5 = (Button) findViewById(R.id.bt_5);
        bt_6 = (Button) findViewById(R.id.bt_6);
        bt_7 = (Button) findViewById(R.id.bt_7);
        bt_8 = (Button) findViewById(R.id.bt_8);
    }


    public void click1(View v) {
        ObjectAnimator translationX = ObjectAnimator.ofFloat(bt_5, "translationX", 0, 500, 0);
        translationX.setDuration(5000);
        translationX.start();
    }

    public void click2(View v) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(bt_2, "scaleY", 1, 0);
        scaleX.setDuration(1000);
//
//        scaleX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                bt_2.postInvalidate();
//                bt_2.invalidate();
//            }
//        });

        scaleX.start();
    }

    public void click3(View v) {
        ObjectAnimator.ofFloat(bt_5, "rotationX", 0, 360)
                .setDuration(500)
                .start();
    }

    public void click4(View v) {
        ObjectAnimator.ofFloat(bt_4, "alpha", 1, 0)
                .setDuration(1000)
                .start();
    }

    public void click5(View v) {
        count++;
        bt_5.setText("" + count);
    }

    public void click6(View v) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(250, 0, 250);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (Integer) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = bt_6.getLayoutParams();
                layoutParams.height = value;
                bt_6.setLayoutParams(layoutParams);
            }
        });
        valueAnimator.start();
    }

    public void click7(View v) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator alpha = ObjectAnimator.ofFloat(bt_7, "alpha", 1, 0, 1, 0, 1, 0, 1).setDuration(2000);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(bt_7, "scaleX", 1, 3, 1).setDuration(3000);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(bt_7, "scaleY", 1, 3, 1).setDuration(3000);

//        animSet.play(anim1).with(anim2);
//        animSet.play(anim2).with(anim3);
//        animSet.play(anim4).after(anim3);

        animatorSet.playTogether(alpha, scaleX, scaleY);
        animatorSet.start();
    }

    public void click8(View v) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
                0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
                0, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
                0, 1f);
        ObjectAnimator.ofPropertyValuesHolder(bt_8, pvhX, pvhY,pvhZ).setDuration(1000).start();
    }
}
