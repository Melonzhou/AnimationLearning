package com.melon.learn.uilearning;

import android.animation.ObjectAnimator;
import android.util.Log;

/**
 * 测试泛型
 * Created by Melon on 2017/10/28.
 */

public class TestGeneric <G, T> {

    private G mGG;
    private T mTT;
    private boolean flag = false;
    private String  obj;


    public TestGeneric (T tt, G gg){
        mGG = gg;
        mTT = tt;
        obj = "hello";

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++)
                    synchronized (obj){
                        if (flag) {
                            Log.e("melon","t1------" + i);
                            flag = false;
                            obj.notify();

                        } else {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++)
                    synchronized (obj){
                        if (!flag) {
                            Log.e("melon","t2------" + i);
                            flag = true;
                            obj.notify();

                        } else {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

            }
        });

        t1.start();
        t2.start();
    }


    public G getGG() {
        Log.e("melon", "gg " + mGG.getClass().getName());
        return mGG;
    }

    public T getTT(){
        Log.e("melon", "tt " + mTT.getClass().getName());
        return mTT;
    }
}
