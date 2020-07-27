package list;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Stack;

/**
 * @author : zzh
 * create at:  2020/7/17
 * @description: 反转链表
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 */
public class ReverseList {

    /**
     * 使用堆栈实现 时间复杂度 O(n)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode newListNode = new ListNode(0);
        ListNode temp = newListNode;
        while (!stack.isEmpty()) {
            temp.next = new ListNode(stack.pop());
            temp = temp.next;
        }
        return newListNode.next;
    }

    /**
     * 迭代方法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;

            head.next = newHead;
            newHead = head;

            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) throws ParseException {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode result = new ReverseList().reverseList2(l1);
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


    }
}
