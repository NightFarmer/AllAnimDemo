package com.nightfarmer.allanimdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ViewAnimation(View v){
        startActivity(new Intent(this, ViewAnimationActivity.class));
    }

    public void PropertyAnimation(View v){
        startActivity(new Intent(this, PropertyAnimationActivity.class));
    }

    public void LayoutAnimation(View v){
        startActivity(new Intent(this, LayoutAnimationActivity.class));
    }

    public void Interpolator(View v){
        startActivity(new Intent(this, InterpolatorActivity.class));
    }
}
