package tree.traversal;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : zzh
 * create at:  2020/8/1
 * @description:层次遍历
 */
public class LevelTraversal {

    /**
     * 非递归实现
     * <p>
     * 使用队列 实现BFS思想
     *
     * @param node
     */
    public void traversal(TreeNode node) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(node);
        while (!list.isEmpty()) {
            TreeNode poll = list.poll();
            System.out.println(poll.val);
            if (poll.left != null) {
                list.add(poll.left);
            }
            if (poll.right != null) {
                list.add(poll.right);
            }
        }
    }

    public List<List<Integer>> traversal2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 这里的 size很关键，存储每一层节点数
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            // 在这里，根据 size，把每一层节点的所有左右孩子都添加都队列里头
            while (size-- > 0) {
                root = queue.poll();
                list.add(root.val);
                if (root.left != null)
                    queue.offer(root.left);
                if (root.right != null)
                    queue.offer(root.right);
            }
            lists.add(list);
        }
        return lists;
    }



    List<List<Integer>> levels = new ArrayList<>();

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> traversal3(TreeNode root) {
        if (root == null)
            return levels;
        helper(root, 0);
        return levels;
    }


    public void helper(TreeNode root, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(root.val);

        if (root.left != null)
            helper(root.left, level + 1);
        if (root.right != null)
            helper(root.right, level + 1);
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

        new LevelTraversal().traversal3(t1);

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
