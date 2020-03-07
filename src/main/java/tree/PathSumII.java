package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zzh
 * create at:  2020/3/6
 * @description:
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        solution2(root, sum, result, new ArrayList<>());
        return result;
    }


    public void solution(TreeNode node, int sum, List<List<Integer>> result, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && sum - node.val == 0) {
            list.add(node.val);
            result.add(list);
            return;
        }
        List<Integer> temp = new ArrayList<>(list);
        if (node.left != null || node.right != null) {
            temp.add(node.val);
        }
        List<Integer> temp2 = new ArrayList<>(temp);
        solution(node.left, sum - node.val, result, temp);
        solution(node.right, sum - node.val, result, temp2);
    }


    public void solution2(TreeNode node, int sum, List<List<Integer>> result, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && sum - node.val == 0) {
            list.add(node.val);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(node.val);
        solution2(node.left, sum - node.val, result, list);
        solution2(node.right, sum - node.val, result, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        /*TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.left = n9;
        n6.right = n10;*/

        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;

        PathSumII pathSumII = new PathSumII();
        List<List<Integer>> result = pathSumII.pathSum(n1, 1);
        for (List<Integer> integers : result) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
