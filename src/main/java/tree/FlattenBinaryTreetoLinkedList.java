package tree;

/**
 * @author : zzh
 * create at:  2020/3/8
 * @description:
 */
public class FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
//        TreeNode node = solution(root, new TreeNode(root.val));
        root = solution2(root);
        System.out.println(root.val);
    }

    public TreeNode solution(TreeNode oldNode, TreeNode node) {
        if (oldNode == null) {
            return null;
        }

        //TreeNode node = new TreeNode(oldNode.val);
        node.right = new TreeNode(oldNode.val);
        solution(oldNode.left, node.right);

        TreeNode temp = node;
        while (temp.right != null) {
            temp = temp.right;
        }
        solution(oldNode.right, temp);

        //node.right = solution(oldNode.left, node);
        //node = node.right == null ? newNode : newNode.right;
        //node.right = solution(oldNode.right, node);
        return node;
    }

    public TreeNode solution2(TreeNode oldNode) {
        if (oldNode == null) {
            return null;
        }

        TreeNode node = new TreeNode(oldNode.val);
        node.right = solution2(oldNode.left);
        TreeNode temp = node;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = solution2(oldNode.right);
        return node;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;

        FlattenBinaryTreetoLinkedList demo = new FlattenBinaryTreetoLinkedList();
        demo.flatten(n1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
