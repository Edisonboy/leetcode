package list;

/**
 * @author : zzh
 * create at:  2020/7/30
 * @description: no.160
 *
 *
 */
public class IntersectionNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        if (lengthA == 0 || lengthB == 0) {
            return null;
        }
        int temp = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            while (temp-- > 0) {
                headA = headA.next;
            }
        }
        if (lengthA < lengthB) {
            while (temp-- > 0) {
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static void main(String[] args) {
        ListNode la1 = new ListNode(1);
        ListNode la2 = new ListNode(2);

        ListNode lb1 = new ListNode(3);
        ListNode lb2 = new ListNode(4);
        ListNode lb3 = new ListNode(5);

        ListNode lc1 = new ListNode(6);
        ListNode lc2 = new ListNode(7);
        ListNode lc3 = new ListNode(8);

        la1.next = la2;

        lb1.next = lb2;
        lb2.next = lb3;

        lc1.next = lc2;
        lc2.next = lc3;

        la2.next = lc1;
        lb3.next = lc1;

        ListNode result = new IntersectionNode().getIntersectionNode(la1, lb1);
        System.out.println(result.val);


    }

    public int getLength(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
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
