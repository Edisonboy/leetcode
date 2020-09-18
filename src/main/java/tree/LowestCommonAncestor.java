package tree;

/**
 * @author : zzh
 * create at:  2020/3/12
 * @description:no.236
 * https://www.youtube.com/watch?v=13m9ZCB8gjw
 *
 * note:
 * 递归寻找到p,q结点，逐层返回就是祖先结点
 *
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;

        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(t1, t2, t6).val);

    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
