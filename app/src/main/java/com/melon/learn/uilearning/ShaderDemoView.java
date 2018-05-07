package com.melon.learn.uilearning;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Melon on 2018/5/7.
 */

public class ShaderDemoView extends View{

    LinearGradient mLinearGradient1;
    LinearGradient mLinearGradient2;

    int[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE};
    float[] positions = {};
    Paint mPaint;
    public ShaderDemoView(Context context) {
        super(context);
        init();
    }

    public ShaderDemoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShaderDemoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ShaderDemoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        mPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mLinearGradient1 = new LinearGradient(0, 0, 200, 40, Color.GREEN, Color.BLUE, Shader.TileMode.REPEAT);
        mLinearGradient2 = new LinearGradient(0, 0, canvas.getWidth(), canvas.getHeight(), colors, null, Shader.TileMode.REPEAT);
        mPaint.setShader(mLinearGradient2);
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), mPaint);

        ComposeShader shader = new ComposeShader(mLinearGradient1, mLinearGradient2, PorterDuff.Mode.ADD);
    }
}
