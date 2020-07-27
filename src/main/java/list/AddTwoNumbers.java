package list;

/**
 * @author : zzh
 * create at:  2020/7/27
 * @description:
 */
public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tempList = result;
        int acl = 0;
        while (l1 != null || l2 != null) {
            int temp = acl;
            if (l1 != null) {
                temp = temp + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp = temp + l2.val;
                l2 = l2.next;
            }

            if (temp >= 10) {
                temp = temp - 10;
                acl = acl - acl + 1;
            }else {
                acl = 0;
            }
            tempList.next = new ListNode(temp);
            tempList = tempList.next;
        }
        if (acl > 0) {
            tempList.next = new ListNode(acl);
        }
        return result.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode la1 = new ListNode(1);
        ListNode la2 = new ListNode(4);
        ListNode la3 = new ListNode(3);
        la1.next = la2;
        la2.next = la3;

        ListNode lb1 = new ListNode(9);
        ListNode lb2 = new ListNode(9);
        ListNode lb3 = new ListNode(4);
        lb1.next = lb2;
        lb2.next = lb3;

        ListNode result = new AddTwoNumbers().addTwoNumbers2(la1, lb1);
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
