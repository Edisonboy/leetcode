package list;

/**
 * @author : zzh
 * create at:  2020/7/29
 * @description:
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 * Follow-up:
 * Can you solve it without using extra space?
 *
 *
 * note:
 * 1. 使用快慢指针找到相同的节点
 * 2. 非环形距离为a，环形开始点到相遇点位距离位b，环形距离为c
 *   公式：s1 = a + b + n1*c （n1为慢节点走的圈数）
 *        s2 = a + b + n2*c （n1为快节点走的圈数）
 *        s2 = 2*s1
 *    所以
 *        a + b = (n2 - n1)*c
 *      a+b是环的整数倍，如果再走a距离，就等于走了n圈环，也就相当于回到了环形开始点
 *
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode start2 = head;
                while (start2 != slow) {
                    start2 = start2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
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
