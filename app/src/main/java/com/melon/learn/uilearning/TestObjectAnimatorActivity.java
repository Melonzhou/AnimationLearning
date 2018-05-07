package com.melon.learn.uilearning;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Melon on 2017/8/30.
 */

public class TestObjectAnimatorActivity extends BaseActivity {

    private ImageView mImage;
    private TextView mAlphaView;
    private TextView mScaleView;
    private TextView mTranslateView;
    private TextView mRotateView;
    private TextView mSetView;
    private ObjectAnimator alphaAnimator;
    private Animator scaleAnimator;
    private ObjectAnimator translateAnimator;
    private ObjectAnimator rotateAnimator;
    private AnimatorSet animatorSet;
    private TranslateAnimation mTransAnimation;


    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == mAlphaView) {
                if (alphaAnimator == null) {
                    alphaAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(TestObjectAnimatorActivity.this, R
                            .animator.anim_object_alpha);
                    alphaAnimator.setTarget(mImage);
                }


                alphaAnimator.start();

            } else if (v == mScaleView) {

                if (scaleAnimator == null) {
                    scaleAnimator = AnimatorInflater.loadAnimator(TestObjectAnimatorActivity.this, R.animator
                            .anim_object_scale);
                    scaleAnimator.setTarget(mImage);
                }


                scaleAnimator.start();

            } else if (v == mTranslateView) {
                if (translateAnimator == null) {
                    translateAnimator = ObjectAnimator.ofFloat(mImage, "translationX", 0, -200);
                    translateAnimator.setDuration(1000);
                    translateAnimator.setRepeatCount(5);
                    translateAnimator.setRepeatMode(ValueAnimator.REVERSE);
                }

                mTransAnimation = new TranslateAnimation(0,0,200,200);
                mTranslateView.setAnimation(mTransAnimation);
                mTransAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                mTransAnimation.start();

                translateAnimator.start();
            } else if (v == mRotateView) {
                if (rotateAnimator == null) {
                    rotateAnimator = ObjectAnimator.ofFloat(mImage, "rotation", 0f, 180f);
                    rotateAnimator.setDuration(1000);
                    rotateAnimator.setRepeatCount(3);
                    rotateAnimator.setRepeatMode(ValueAnimator.RESTART);
                }

                rotateAnimator.start();
            } else if (v == mSetView) {
                if (animatorSet == null) {
                    animatorSet = new AnimatorSet();
                    animatorSet.setTarget(mImage);
                }

                if (alphaAnimator == null) {
                    alphaAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(TestObjectAnimatorActivity.this, R
                            .animator.anim_object_alpha);
                    alphaAnimator.setTarget(mImage);
                }
                if (scaleAnimator == null) {
                    scaleAnimator = AnimatorInflater.loadAnimator(TestObjectAnimatorActivity.this, R.animator
                            .anim_object_scale);
                    scaleAnimator.setTarget(mImage);
                }

                animatorSet.playTogether(alphaAnimator, scaleAnimator);
                animatorSet.start();

            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
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


    private void testAnimation(){
        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                super.applyTransformation(interpolatedTime, t);
            }
        };
    }
}
