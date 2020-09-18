package list;

/**
 * @author : zzh
 * create at:  2020/7/27
 * @description:
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 *
 * note：
 *
 * 总体思路是：归并算法
 *
 * 1. 两个指针[fast/slow]使用1:2的的遍历速度，找到链表的中间位置
 * 2. 加入 prev 消除 head 的后面链表
 * 3. 递归继续拆解链表
 * 4. 最后合并
 *
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 把两个链表断开连接 prev 与 slow
        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }

    public static void main(String[] args) {
        ListNode la1 = new ListNode(4);
        ListNode la2 = new ListNode(2);
        ListNode la3 = new ListNode(1);
        ListNode la4 = new ListNode(3);
        ListNode la5 = new ListNode(9);
        ListNode la6 = new ListNode(7);
        ListNode la7 = new ListNode(6);
        ListNode la8 = new ListNode(11);
        ListNode la9 = new ListNode(12);



        la1.next = la2;
        la2.next = la3;
        la3.next = la4;
        la4.next = la5;
        la5.next = la6;
        la6.next = la7;
        la7.next = la8;
        la8.next = la9;

        ListNode result = new SortList().sortList(la1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
