package com.example.mytestdemo.LeeCode;

/**
 * LeeCode 206
 * 反转链表
 * 5->4->3->2->1->null
 * null <- 5 < -4 <-3 <-2 <-1
 * <p>
 * 构造出一个null节点 pre
 * 遍历链表 头节点指向pre
 * pre = 当前节点
 * <p>
 * 下一次遍历 后一个节点指向上面的pre节点 如此
 */

public class ReverseList {


    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;
            while (null != curr) {
                //1+3 就是遍历链表而已 2是核心
                //1
                ListNode temp = curr.next;

                //2
                curr.next = pre;
                pre = curr;

                //3
                curr = temp;

            }
            return pre;
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

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Solution solution = new Solution();
        solution.reverseList(listNode1);
    }
}