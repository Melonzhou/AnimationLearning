package com.melon.learn.uilearning;

import android.util.Log;
import android.view.TextureView;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Melon on 2018/3/24.
 */

public class TestThreadPool {
    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5);
    BlockingQueue<Runnable> queue2 = new LinkedBlockingDeque<Runnable>();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 20, 120, TimeUnit.SECONDS, workQueue);


    public TestThreadPool() {


        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();
        queue.add(new MyTask(2));

        HashMap<Integer, String> map;

    }

    public void testRun(){
        for (int i = 0; i< 25; i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            Log.i("melon","线程池中线程数目："+ executor.getPoolSize()+"，队列中等待执行的任务数目："+ executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
    }


    public class MyTask implements Runnable{

        public int number;
        public MyTask(int number){
            this.number = number;
        }
        @Override
        public void run() {

            Log.e("melon", "run task " + number);
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.w("melon", "task " + number +" over !");
        }
    }
}
