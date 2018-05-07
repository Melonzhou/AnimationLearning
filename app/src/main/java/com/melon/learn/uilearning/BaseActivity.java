package com.melon.learn.uilearning;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

/**
 * Created by Melon on 2018/3/24.
 */

public class BaseActivity extends Activity {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        Log.e("melon","onCreate " + getClass().getName());
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onStart() {
        Log.e("melon","onStart " + getClass().getName());
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.e("melon","onRestart " + getClass().getName());
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.e("melon","onResume " + getClass().getName());
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e("melon","onPause " + getClass().getName());
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("melon","onStop " + getClass().getName());
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e("melon","onDestroy " + getClass().getName());
        super.onDestroy();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.e("melon","onWindowFocusChanged  " + hasFocus + getClass().getName());
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.e("melon","onSaveInstanceState " + getClass().getName());
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e("melon","onRestoreInstanceState " + getClass().getName());
        super.onRestoreInstanceState(savedInstanceState);
    }
}
