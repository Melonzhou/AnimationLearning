package com.melon.learn.uilearning;


/**
 * Created by Melon on 2018/3/24.
 */

public class SortUtil {


    public static int[] sortHeap(int[] array) {
        buildHeap(array);// 构建堆
        int n = array.length;//数组中元素的个数

        for (int i = n - 1; i >= 1; i--) {
            swap(array, 0, i);//交换首尾元素
            adjustHeap(array, 0, i);//调整堆
        }
        return array;
    }



    public static void buildHeap(int[] array){
        int n = array.length;// 数组中元素的个数

        for (int i = n / 2 - 1; i >= 0; i--)//i= n/2-1  表示最后一个非叶子结点的索引值
            adjustHeap(array, i, n);
    }

    private static void adjustHeap(int[] arr, int index, int length){

        int left = index * 2 + 1; // 左孩子下标
        int right = left + 1; // 右孩子下标
        int maxIndex = 0; // 父结点、左右子结点中最大值的下标

       // 找出父结点、左右子结点中最大值的下标

        if (left < length && arr[left] > arr[index]){
            maxIndex = left;
        } else {
            maxIndex = index;
        }

        if (right < length && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }

        if (maxIndex != index) {
            swap(arr, maxIndex, index); // 最大值和父结点交换
            adjustHeap(arr, maxIndex, length); // 递归进去
        }
    }

    private static void swap(int[] array, int i, int i2) {
        int temp = array[i];
        array[i] = array[i2];
        array[i2] = temp;
    }


    public static int[] insertSort(int[] array){
        int length = array.length;
        int curData = 0;
        int preIndex = 0;

        for (int i = 1; i < length; i++) {
            curData = array[i];
            preIndex = i - 1;

            while(preIndex > 0 && array[preIndex] > curData){

//                array[preIndex + 1] = array[preIndex];
//                swap(array, preIndex, preIndex + 1);

                preIndex --;
            }

            array[preIndex] = curData;


        }

        return array;
    }

}
