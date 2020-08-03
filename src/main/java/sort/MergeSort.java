package sort;


/**
 * @author : zzh
 * create at:  2020/3/13
 * @description:归并排序
 */
public class MergeSort {

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort2(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;
        int mid = (startIndex + endIndex) >> 1;
        sort(array, startIndex, mid);
        sort(array, mid + 1, endIndex);
        merge(array, startIndex, endIndex);
    }

    public void sort2(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;
        int mid = (startIndex + endIndex) >> 1;
        sort2(array, startIndex, mid);
        sort2(array, mid + 1, endIndex);
        merge2(array, startIndex, endIndex);
    }

    /**
     * 冒泡排序
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public void merge(int[] array, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            for (int j = startIndex + 1; j <= endIndex; j++) {
                if (array[startIndex] > array[j]) {
                    int temp = array[startIndex];
                    array[startIndex] = array[j];
                    array[j] = temp;
                }
            }
            startIndex++;
        }
    }

    /**
     * 双指针
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public void merge2(int[] array, int startIndex, int endIndex) {
        int[] temp = new int[array.length];
        int mid = (startIndex + endIndex) >> 1;
        int i = startIndex;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= endIndex) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];
            }else {
                temp[t++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = array[i++];
        }
        while (j <= endIndex) {
            temp[t++] = array[j++];
        }
        t = 0;
        // 将temp中的元素全部拷贝到原数组中
        while (startIndex <= endIndex) {
            array[startIndex++] = temp[t++];
        }
    }

    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();
        {
            long startTime = System.currentTimeMillis();
            int i = 0;
            while (i < 500000000) {
                int[] array = {11, 8, 3, 9, 7, 1, 2, 5};
                mergeSort.sort(array);
                i++;
            }
            System.out.println("time:" + (System.currentTimeMillis() - startTime));
        }
        {
            long startTime = System.currentTimeMillis();
            int i = 0;
            while (i < 500000000) {
                int[] array = {11, 8, 3, 9, 7, 1, 2, 5};
                mergeSort.sort2(array);
                i++;
            }
            System.out.println("time:" + (System.currentTimeMillis() - startTime));
        }
    }



}
