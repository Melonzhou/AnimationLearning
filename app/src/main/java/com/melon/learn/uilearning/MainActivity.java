package com.melon.learn.uilearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View mTweenView;
    private View mFrameView;
    private View mPropertyView;

    private View.OnClickListener mCommonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (view == mTweenView) {

            } else if (view == mFrameView) {

            } else if (view == mPropertyView) {
                Intent it = new Intent(MainActivity.this, TestObjectAnimatorActivity.class);
                startActivity(it);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mTweenView = findViewById(R.id.view_tween_anim);
        mFrameView = findViewById(R.id.view_frame_anim);
        mPropertyView = findViewById(R.id.view_property_anim);

        mTweenView.setOnClickListener(mCommonClickListener);
        mFrameView.setOnClickListener(mCommonClickListener);
        mPropertyView.setOnClickListener(mCommonClickListener);
    }
}
