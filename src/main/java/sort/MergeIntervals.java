package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : zzh
 * create at:  2020/3/14
 * @description:
 *
 * 1.使用newInterval记录上一个的数组元素
 *
 * 2.通过遍历intervals， 用当前的interval与newInterval对比，如果当前的第一个元素小于上一个的第二个元素，则可以合并
 * 将newInterval的第二个元素更新为当前最大值， 即使已经进入list，也可以改变它的值
 *
 * 3.并且通过直接修改newInterval可以改变
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            // Overlapping intervals, move the end if needed
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }else {
                // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);

    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(mergeIntervals.merge(arr));
    }
}
