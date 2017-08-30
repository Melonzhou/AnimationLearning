package com.melon.learn.uilearning;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Melon on 2017/8/30.
 */

public class TestObjectAnimatorActivity extends Activity{

    private ImageView mImage;
    private TextView mAlphaView;
    private TextView mScaleView;
    private TextView mTranslateView;
    private TextView mRotateView;
    private TextView mSetView;
    private ObjectAnimator alphaAnimator;
    private Animator scaleXAnimator;
    private ObjectAnimator translateAnimator;
    private ObjectAnimator rotateAnimator;
    private AnimatorSet animatorSet;


    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == mAlphaView) {
                alphaAnimator = (ObjectAnimator)AnimatorInflater.loadAnimator(TestObjectAnimatorActivity.this, R.animator
                        .anim_object_alpha);
                alphaAnimator.setTarget(mImage);
                alphaAnimator.start();

            } else if (v == mScaleView) {

                scaleXAnimator = AnimatorInflater.loadAnimator(TestObjectAnimatorActivity.this, R.animator
                        .anim_object_scale);
                scaleXAnimator.setTarget(mImage);
                scaleXAnimator.start();

            } else if (v == mTranslateView) {
                translateAnimator = ObjectAnimator.ofFloat(mImage, "translationX", 0, -200);
                translateAnimator.setDuration(1000);
                translateAnimator.setRepeatCount(5);
                translateAnimator.setRepeatMode(ValueAnimator.REVERSE);
                translateAnimator.start();
            } else if (v == mRotateView) {
                rotateAnimator = ObjectAnimator.ofFloat(mImage, "rotation", 0f, 180f);
                rotateAnimator.setDuration(1000);
                rotateAnimator.setRepeatCount(3);
                rotateAnimator.setRepeatMode(ValueAnimator.RESTART);
                rotateAnimator.start();
            } else if (v == mSetView){
                animatorSet = new AnimatorSet();
                animatorSet.setTarget(mImage);
                alphaAnimator = (ObjectAnimator)AnimatorInflater.loadAnimator(TestObjectAnimatorActivity.this, R.animator
                        .anim_object_alpha);

                animatorSet.playTogether(alphaAnimator,scaleXAnimator);
                animatorSet.start();

            }
        }
    };
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_test_activity);

        mImage = (ImageView) findViewById(R.id.view_icon);
        mAlphaView = (TextView) findViewById(R.id.view_alpha);
        mScaleView = (TextView) findViewById(R.id.view_scale);
        mTranslateView = (TextView) findViewById(R.id.view_translate);
        mRotateView = (TextView) findViewById(R.id.view_rotate);
        mSetView = (TextView) findViewById(R.id.view_set);

        mAlphaView.setOnClickListener(mClickListener);
        mScaleView.setOnClickListener(mClickListener);
        mTranslateView.setOnClickListener(mClickListener);
        mRotateView.setOnClickListener(mClickListener);
        mSetView.setOnClickListener(mClickListener);


    }
}
