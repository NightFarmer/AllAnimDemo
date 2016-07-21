package com.nightfarmer.allanimdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

public class InterpolatorActivity extends AppCompatActivity {

    ImageView iv_target;
    private float translationY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);

        iv_target = (ImageView) findViewById(R.id.iv_target);
        translationY = iv_target.getTranslationY();

    }

    public void BounceInterpolator(View v) {
        startAnim(new BounceInterpolator());
    }

    public void AnticipateInterpolator(View v) {
        startAnim(new AnticipateInterpolator());
    }

    public void AccelerateDecelerateInterpolator(View v) {
        startAnim(new AccelerateDecelerateInterpolator());
    }

    public void AccelerateInterpolator(View v) {
        startAnim(new AccelerateInterpolator());
    }

    public void AnticipateOvershootInterpolator(View v) {
        startAnim(new AnticipateOvershootInterpolator());
    }

    public void DecelerateInterpolator(View v) {
        startAnim(new DecelerateInterpolator());
    }

    public void LinearInterpolator(View v) {
        startAnim(new LinearInterpolator());
    }

    public void OvershootInterpolator(View v) {
        startAnim(new OvershootInterpolator());
    }

    public void CycleInterpolator(View v) {
        startAnim(new CycleInterpolator(0.5f));
    }

    public void restY(View v){
        iv_target.setTranslationY(translationY);
    }

    public void startAnim(TimeInterpolator interpolator) {
        ObjectAnimator translationY1 = ObjectAnimator.ofFloat(iv_target, "translationY", translationY, translationY + 500);
        translationY1.setDuration(1000);
        translationY1.setInterpolator(interpolator);
        translationY1.start();
    }
}
