package sort;

import java.util.Arrays;

/**
 * @author : zzh
 * create at:  2020/3/18
 * @description:插入排序
 */
public class InsertSort {

    public void sort(int[] array) {
        if (array.length == 0) return;
        int i,j, temp;

        for (i = 0; i < array.length - 1; i++) {
            temp = array[i];
            for (j = i; j > 0; j--) {
                if (array[j] < array[j-1])
                    array[j] = array[j-1];
                else
                    break;
            }
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {3,1,4,5};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(array);
        System.out.println(Arrays.toString(array));

    }
}
