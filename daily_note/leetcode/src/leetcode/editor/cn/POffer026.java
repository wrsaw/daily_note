package leetcode.editor.cn;

//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 104] 
// 1 <= node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/ 
// Related Topics 栈 递归 链表 双指针 
// 👍 47 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class POffer026{
    public static void main(String[] args) {
        Solution solution = new POffer026().new Solution();
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        //数组就行，栈更复杂了。。。
        Deque<ListNode> stack = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        ListNode left;
        ListNode lnext = head;
        ListNode right;
        ListNode rlast = null;
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = lnext;
            if (left == right) {
                if (rlast != null) {
                    rlast.next = left;
                    right.next = null;
                }
                break;
            } else {
                if (rlast != null) {
                    rlast.next = left;
                }
                if (left.next == right) {
                    right.next = null;
                    break;
                }
                lnext = left.next;
                left.next = right;
                rlast = right;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}