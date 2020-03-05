package tree;

/**
 * @author : zzh
 * create at:  2020/3/5
 * @description:
 */
public class PostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return soultion(postorder.length -1, 0, inorder.length -1, inorder, postorder);
    }

    public TreeNode soultion(int postIndex, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postIndex < 0 || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postIndex]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                inIndex = i;
                break;
            }
        }
        node.left = soultion(postIndex - inEnd + inIndex - 1, inStart, inIndex - 1, inorder, postorder);
        node.right = soultion(postIndex - 1, inIndex + 1, inEnd, inorder, postorder);
        return node;
    }


    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        PostorderTraversal demo = new PostorderTraversal();

        TreeNode t = demo.buildTree(inorder, postorder);
        System.out.println(t.val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
