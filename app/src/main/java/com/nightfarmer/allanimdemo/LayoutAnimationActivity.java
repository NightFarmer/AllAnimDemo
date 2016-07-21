package com.nightfarmer.allanimdemo;

import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class LayoutAnimationActivity extends AppCompatActivity {

    boolean removeOrAdd = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);

        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.content);

        final Button button = new Button(this);
        linearLayout.addView(button, 0);

        button.setOnClickListener(getL(linearLayout));

        LayoutTransition mTransition = new LayoutTransition();

//        mTransition.setAnimator(LayoutTransition.APPEARING, mTransition.getAnimator(LayoutTransition.APPEARING));
        mTransition.setAnimator(LayoutTransition.APPEARING, ObjectAnimator.ofFloat(this, "scaleX", 0, 1));

        mTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, mTransition.getAnimator(LayoutTransition.CHANGE_APPEARING));
        mTransition.setAnimator(LayoutTransition.DISAPPEARING, mTransition.getAnimator(LayoutTransition.DISAPPEARING));
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator alpha = ObjectAnimator.ofFloat(this, "alpha", 1, 0);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(this, "scaleX", 1, 2f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(this, "scaleY", 1, 2f);
        animatorSet.playTogether(alpha, scaleX, scaleY);
        animatorSet.setDuration(300);
        mTransition.setAnimator(LayoutTransition.DISAPPEARING, animatorSet);

        mTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, mTransition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING));

        linearLayout.setLayoutTransition(mTransition);
    }

    @NonNull
    private View.OnClickListener getL(final LinearLayout linearLayout) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayout.getChildCount() > 10 && removeOrAdd) {
                    removeOrAdd = false;
                }

                if (linearLayout.getChildCount() == 1 && !removeOrAdd) {
                    removeOrAdd = true;
                }

                if (removeOrAdd) {
                    Button button = new Button(LayoutAnimationActivity.this);
                    button.setText("文字看效果");
                    button.setOnClickListener(getL(linearLayout));
                    linearLayout.addView(button, linearLayout.indexOfChild(v));
                } else {
                    linearLayout.removeView(v);
                }

            }
        };
    }
}
