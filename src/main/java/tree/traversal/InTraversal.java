package tree.traversal;

import java.util.Stack;

/**
 * @author : zzh
 * create at:  2020/8/1
 * @description:
 */
public class InTraversal {

    public void traversal1(TreeNode root) {
        if (root == null)
            return;

        traversal1(root.left);
        System.out.println(root.val);
        traversal1(root.right);
    }


    public void traversal2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }


    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;

        new InTraversal().traversal2(t1);
    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
