package com.melon.learn.uilearning;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends BaseActivity {

    private View mTweenView;
    private View mFrameView;
    private View mPropertyView;
    private MediaPlayer mMediaPlayer;
    private TextureView mTextureView;

    private TestThreadPool threadPool = new TestThreadPool();

    private View.OnClickListener mCommonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (view == mTweenView) {
//                TestGeneric ss = new TestGeneric(new TestStaticClass(0, 0), mTweenView);
//                ss.getGG();
//                ss.getTT();

                int[] array = {9,3,4,6,2,1,0,8,5,7};
                int[] s = SortUtil.insertSort(array);
                for (int i : s) {
                    Log.i("melon"," -> " + i);
                }

            } else if (view == mFrameView) {
//                trailingZeros(105);
                threadPool.testRun();

            } else if (view == mPropertyView) {
                Intent it = new Intent(MainActivity.this, TestObjectAnimatorActivity.class);
                startActivity(it);
            }
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mTweenView = findViewById(R.id.view_tween_anim);
        mFrameView = findViewById(R.id.view_frame_anim);
        mPropertyView = findViewById(R.id.view_property_anim);

        mTweenView.setOnClickListener(mCommonClickListener);
        mFrameView.setOnClickListener(mCommonClickListener);
        mPropertyView.setOnClickListener(mCommonClickListener);

        mTextureView = new TextureView(this);
        mMediaPlayer = new MediaPlayer();
        mTextureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            @Override
            public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
                // SurfaceTexture准备就绪
                openMediaPlayer(surface);
            }

            @Override
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
                // SurfaceTexture缓冲大小变化
            }

            @Override
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                // SurfaceTexture即将被销毁
                return false;
            }

            @Override
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {
                // SurfaceTexture通过updateImage更新
            }
        });


    }

    private void openMediaPlayer(SurfaceTexture surface) {
        try {
            String url = "";
            mMediaPlayer.setDataSource(getApplicationContext(), Uri.parse(url));
            mMediaPlayer.setSurface(new Surface(surface));
            mMediaPlayer.prepareAsync();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 链表逆置
     * @param rootNode
     */
    public void lianbiaonizhi(LinkNode rootNode){
        LinkNode head;
        LinkNode p; // 当前待插入结点
        LinkNode q; // 下一个待插入结点

        head = rootNode;
        p = head.next;

        if (p == null) {
            return;
        }

        q = p.next;
        head.next = null;

        while(p != null) {
            p.next = head.next;
            head.next = p;
            p = q;
            q = q.next;
        }
    }


    /**
     * 树的广度遍历，借助队列，根、左、右
     * @param rootNode
     */
    public void guangdubianli(TreeNode rootNode){
        if (rootNode == null) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);
        while (!queue.isEmpty()) {
           TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            list.add(node.value);
        }

        //list中存的就是最终打印的结果
    }

    /**
     * 树的深度遍历，借助栈完成，根、右、左
     * @param rootNode
     */
    public void shengdubiali(TreeNode rootNode){
        if (rootNode == null) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(rootNode);
//        stack.push(rootNode); 这个方法是干什么的？懵B
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }

            list.add(node.value);
        }

        //list中存的就是最终打印的结果
    }

    /**
     * 递归方式深度遍历，也是前（先）序遍历：根、左、右
     * @param node
     * @param list
     */

    public void diguiShengduBianli(TreeNode node, ArrayList<Integer> list){

        if (node == null || list == null) {
            return;
        }

        list.add(node.value);
        diguiShengduBianli(node.left, list);
        diguiShengduBianli(node.right, list);

    }

    /**
     * 中序遍历：左、根、右
     * @param node
     * @param list
     */
    public void diguizhongxubianli(TreeNode node, ArrayList<Integer> list){
        if (node == null || list == null) {
            return;
        }
        diguizhongxubianli(node.left, list);
        list.add(node.value);
        diguizhongxubianli(node.right, list);
    }
    /**
     * 后序遍历：左、右、根
     * @param node
     * @param list
     */
    public void diguihouxubianli(TreeNode node, ArrayList<Integer> list){
        if (node == null || list == null) {
            return;
        }
        diguihouxubianli(node.left, list);
        diguihouxubianli(node.right, list);
        list.add(node.value);
    }






}
