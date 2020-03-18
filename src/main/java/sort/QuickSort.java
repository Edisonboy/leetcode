package sort;

import java.util.Arrays;

/**
 * @author : zzh
 * create at:  2020/3/16
 * @description:快速排序
 */
public class QuickSort {

    public void sort(int[] array, int left, int right) {
        if (left >= right) return;
        int i,j,t,temp;
        temp = array[left];
        i = left;
        j = right;
        while (i != j) {
            while (array[j] >= temp && i < j) {
                j--;
            }
            while (array[i] <= temp && i < j) {
                i++;
            }
            // 交换两个数的位置
            if (i < j) {
                t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        array[left] = array[i];
        array[i] = temp;
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,9,2};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
