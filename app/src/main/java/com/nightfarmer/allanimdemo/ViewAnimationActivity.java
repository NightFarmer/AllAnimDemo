package com.nightfarmer.allanimdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class ViewAnimationActivity extends AppCompatActivity {
    Button bt_1;
    Button bt_2;
    Button bt_3;
    Button bt_4;
    Button bt_5;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        bt_1 = (Button) findViewById(R.id.bt_1);
        bt_2 = (Button) findViewById(R.id.bt_2);
        bt_3 = (Button) findViewById(R.id.bt_3);
        bt_4 = (Button) findViewById(R.id.bt_4);
        bt_5 = (Button) findViewById(R.id.bt_5);
    }

    public void click1(View v) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 500, 0, 0);
        translateAnimation.setDuration(3000);
        bt_5.startAnimation(translateAnimation);
    }

    public void click2(View v) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1.5f, 0, 1.5f);
        scaleAnimation.setDuration(1000);
        bt_2.startAnimation(scaleAnimation);
    }

    public void click3(View v) {
        RotateAnimation rAnima = new RotateAnimation(0, 70);//顺时针旋转70度
        rAnima.setDuration(1000);
        bt_3.startAnimation(rAnima);
    }

    public void click4(View v) {
        AlphaAnimation aAnima = new AlphaAnimation(1.0f, 0.0f);//从全不透明变为全透明
        aAnima.setDuration(1000);
        bt_4.startAnimation(aAnima);
    }

    public void click5(View v) {
        count++;
        bt_5.setText("" + count);
    }
}
