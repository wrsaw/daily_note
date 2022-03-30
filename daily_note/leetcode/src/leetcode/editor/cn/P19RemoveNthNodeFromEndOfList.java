package leetcode.editor.cn;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1473 👎 0

public class P19RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        solution.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode f = head;
            ListNode s = head;
            for (int i = 0; i < n; i++) {
                f = f.next;
            }
            if (f == null) {
                return s.next;
            }
            while (f.next != null) {
                f = f.next;
                s = s.next;
            }
            if (s.next != null) {
                s.next = s.next.next;
            }
            return head;

            /*int num = 0;
            ListNode temp = head;
            while (temp != null) {
                temp = temp.next;
                num++;
            }
            if (num == 1 && n == 1) {
                return null;
            }
            if (n == num) {
                return head.next;
            }
            temp = head;
            for (int i = 0; i < num; i++) {
                if (i == num - n - 1) {
                    temp.next = temp.next.next;
                    return head;
                }
                temp = temp.next;
            }
            return head;*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}