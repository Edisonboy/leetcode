package list;

/**
 * @author : zzh
 * create at:  2020/7/17
 * @description:
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class MergeList {

    /**
     * 迭代方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newNode = new ListNode(0);
        ListNode temp = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return newNode.next;
    }

    /**
     * 递归方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {
//        ListNode la1 = new ListNode(1);
//        ListNode la2 = new ListNode(2);
//        ListNode la3 = new ListNode(4);
//        la1.next = la2;
//        la2.next = la3;
//
//        ListNode lb1 = new ListNode(1);
//        ListNode lb2 = new ListNode(3);
//        ListNode lb3 = new ListNode(4);
//        lb1.next = lb2;
//        lb2.next = lb3;


        ListNode la1 = new ListNode(1);
        ListNode la2 = new ListNode(1);
        ListNode la3 = new ListNode(5);
        la1.next = la2;
        la2.next = la3;

        ListNode lb1 = new ListNode(4);
        ListNode lb2 = new ListNode(4);
        ListNode lb3 = new ListNode(4);
        lb1.next = lb2;
        lb2.next = lb3;


        ListNode result = new MergeList().mergeTwoLists(la1, lb1);
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



