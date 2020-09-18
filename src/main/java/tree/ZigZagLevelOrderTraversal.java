package tree;

import java.util.*;

/**
 * @author : zzh
 * create at:  2020/2/22
 * @description:no.103
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class ZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zigzag = false;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                if (zigzag) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
            zigzag = !zigzag;
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode t1 = new ZigZagLevelOrderTraversal.TreeNode(2);
        TreeNode t2 = new ZigZagLevelOrderTraversal.TreeNode(0);
        TreeNode t3 = new ZigZagLevelOrderTraversal.TreeNode(4);
        TreeNode t4 = new ZigZagLevelOrderTraversal.TreeNode(1);
        TreeNode t5 = new ZigZagLevelOrderTraversal.TreeNode(3);
        TreeNode t6 = new ZigZagLevelOrderTraversal.TreeNode(-1);
        TreeNode t7 = new ZigZagLevelOrderTraversal.TreeNode(5);
        TreeNode t8 = new ZigZagLevelOrderTraversal.TreeNode(1);
        TreeNode t9 = new ZigZagLevelOrderTraversal.TreeNode(6);
        TreeNode t10 = new ZigZagLevelOrderTraversal.TreeNode(8);

        t2.left = t1;
        t2.right = t3;

        t1.left = t4;
        t3.left = t5;
        t3.right = t6;

        t4.left = t7;
        t4.right = t8;

        t5.right = t9;
        t6.right = t10;

        /*LevelOrderTraversal.TreeNode t1 = new LevelOrderTraversal.TreeNode(1);
        LevelOrderTraversal.TreeNode t2 = new LevelOrderTraversal.TreeNode(2);
        LevelOrderTraversal.TreeNode t3 = new LevelOrderTraversal.TreeNode(3);
        t2.left = t1;
        t2.right = t3;*/

        ZigZagLevelOrderTraversal v = new ZigZagLevelOrderTraversal();
        List<List<Integer>> list = v.zigzagLevelOrder(t2);
        for (List<Integer> integers : list) {
            System.out.println(Arrays.toString(integers.toArray()));
        }

        List<Integer> aL = new ArrayList<>();
        aL.add(1);
        aL.add(2);
        aL.add(3);
        aL.add(1, 0);
        System.out.println(Arrays.toString(aL.toArray()));

        List<Integer> lL = new ArrayList<>();
        lL.add(1);
        lL.add(2);
        lL.add(3);
        lL.add(0, 0);
        System.out.println(Arrays.toString(lL.toArray()));

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
