package tree;

/**
 * @author : zzh
 * create at:  2020/3/6
 * @description:
 */
public class PathSum {


    public boolean hasPathSum(TreeNode root, int sum) {
        return solution(root, sum, 0);
    }

    public boolean solution(TreeNode node, int sum, int total) {
        if (node == null) return false;

        if (node.left == null && node.right == null && total + node.val == sum){
            return true;
        }
        return solution(node.right, sum, node.val + total) || solution(node.left, sum, node.val + total);
    }

    /**
     * 利用sum做减法
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum2(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.right = n9;

        /*TreeNode n1 = new TreeNode(-2);
        TreeNode n2 = new TreeNode(-3);
        n1.right = n2;*/

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(n1, -5));


    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
