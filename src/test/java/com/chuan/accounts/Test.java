package com.chuan.accounts;

public class Test {

    public static void main(String[] args) {
        int[] array = {3, 6, 1, 9, 2};
        int result = findIndex(array, 9);
        System.out.println(result);

    }


    //冒泡排序
    public static int[] sort(int[] array) {
        if (array.length <= 0) {
            return array;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    //二分查找
    public static int findIndex(int[] array, int num) {
        array = sort(array);
        int start = 0;
        int end = array.length - 1;
        int modIndex = (start + end) / 2;
        System.out.println("取到的中间下标为:" + modIndex);
        do {
            if (array[modIndex] > num) {
                end = modIndex;
            }else if(array[modIndex] < num){
                start = modIndex;
            }else {
                break;
            }
            modIndex = (start + end) / 2;
        } while (modIndex > start && modIndex < end);
        return modIndex;
    }

}
