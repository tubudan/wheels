package pers.hx.leetcode;

/**
 * @description:
 * @create: 2021-12-14 10:51
 */

public class SumTwoNumsList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static class ListNode {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode now = root;
        int up = 0;
        int sum = 0;
        while (l1.next != null || l2.next != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            sum = val1 + val2 + up;
            up = sum / 10;
            sum = sum % 10;
            ListNode sumNode = new ListNode(sum);
            now = sumNode;
            now.next = sumNode;
            if (l1.next != null) l1 = l1.next;
            if (l2.next != null) l2 = l2.next;
        }
        return root.next;
    }
}
