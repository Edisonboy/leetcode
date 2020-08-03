package sort;

import java.util.Arrays;

/**
 * @author : zzh
 * create at:  2020/7/31
 * @description: 冒泡排序
 */
public class BubbleSort {

    public void sort(int[] a) {
        int len = a.length;
        if (len == 0) {
            return;
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,1,5,3,4};
        new BubbleSort().sort(a);
        System.out.println(Arrays.toString(a));
    }

}
