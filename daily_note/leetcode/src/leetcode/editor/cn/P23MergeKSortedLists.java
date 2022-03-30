package leetcode.editor.cn;

//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 
// 👍 1435 👎 0

import java.util.PriorityQueue;

public class P23MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //解法一：常规
    /*public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode listNode = lists[0];
        for (int i = 1; i < lists.length; i++) {
            listNode = mergeTwoLists(listNode, lists[i]);
        }
        return listNode;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode tempNode = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (node == null) {
                    node = new ListNode(l1.val);
                    tempNode = node;
                    l1 = l1.next;
                } else {
                    tempNode.next = l1;
                    tempNode = l1;
                    l1 = l1.next;
                }
            } else {
                if (node == null) {
                    node = new ListNode(l2.val);
                    tempNode = node;
                    l2 = l2.next;
                } else {
                    tempNode.next = l2;
                    tempNode = l2;
                    l2 = l2.next;
                }
            }
        }
        if (l1 == null && l2 == null) {
            return node;
        } else if (l1 == null) {
            if (node == null) {
                return l2;
            }
            tempNode.next = l2;
        } else {
            if (node == null) {
                return l1;
            }
            tempNode.next = l1;
        }
        return node;
    }*/

    //解法二：分治，一对一对合并

    //解法三：优先队列
    private class Status implements Comparable<Status> {
        private ListNode node;
        private int val;

        Status(ListNode node, int val) {
            this.node = node;
            this.val = val;
        }

        @Override
        public int compareTo(Status s) {
            return this.val - s.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<>();
    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node, node.val));
            }
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            temp.next = f.node;
            temp = temp.next;
            if (f.node.next != null) {
                queue.offer(new Status(f.node.next, f.node.next.val));
            }
        }
        return head.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}