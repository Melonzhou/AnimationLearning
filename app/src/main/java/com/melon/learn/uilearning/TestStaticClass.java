package com.melon.learn.uilearning;

import android.util.Log;

/**
 * Created by Melon on 2017/10/28.
 */

public class TestStaticClass {
    public static int x = 10;
    public static final int y = 20;
    static {
        Log.e("melon", "static {} x =" + x);
    }

    public TestStaticClass(int xx, int yy) {
        x = xx;
        Log.e("melon", " constructor x =" + x);
    }

    public static void showLogY() {
        Log.e("melon", " show logY y =" + y);
    }

    public static void showLogX() {
        Log.e("melon", " show logX x =" + x);
    }

}
