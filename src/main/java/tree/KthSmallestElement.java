package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zzh
 * create at:  2020/3/10
 * @description:
 */
public class KthSmallestElement {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        solution(root, k, list);
        return list.get(k - 1);
    }

    public boolean solution(TreeNode node, int k, List<Integer> list) {
        if (node == null) {
            return false;
        }
        if (node.left == null && list.size() >= k) {
            return true;
        }
        if (solution(node.left, k, list)) {
            return true;
        }
        list.add(node.val);
        return solution(node.right, k, list);
        //return solution(node.left, k, list) || solution(node.right, k, list);
    }

    public static void main(String[] args) {
        /*TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;*/

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        n1.left = n2;


        KthSmallestElement element = new KthSmallestElement();
        System.out.println(element.kthSmallest(n1, 2));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
