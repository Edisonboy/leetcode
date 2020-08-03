package list;

/**
 * @author : zzh
 * create at:  2020/7/30
 * @description:
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return lists[0];
        }
        ListNode l = lists[0];
        for (int i = 1; i < length; i++) {
            l = merge(l, lists[i]);

        }
        return l;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode la1 = new ListNode(1);
        ListNode la2 = new ListNode(4);
        ListNode la3 = new ListNode(5);

        ListNode lb1 = new ListNode(1);
        ListNode lb2 = new ListNode(3);
        ListNode lb3 = new ListNode(4);

        ListNode lc1 = new ListNode(2);
        ListNode lc2 = new ListNode(6);

        la1.next = la2; la2.next = la3;
        lb1.next = lb2; lb2.next = lb3;
        lc1.next = lc2;

        ListNode[] list = {la1, lb1, lc1};

        ListNode result = new MergeKLists().mergeKLists(list);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
