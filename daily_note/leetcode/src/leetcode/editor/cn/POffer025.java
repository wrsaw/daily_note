package leetcode.editor.cn;

//给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。 
//
// 
//
// 注意：本题与主站 445 题相同：https://leetcode-cn.com/problems/add-two-numbers-ii/ 
// Related Topics 栈 链表 数学 
// 👍 39 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class POffer025{
    public static void main(String[] args) {
        Solution solution = new POffer025().new Solution();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(7, l3);

        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(6, l5);
        ListNode l7 = new ListNode(5, l6);
        System.out.println(solution.addTwoNumbers(l4, l7));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution {

//[7,2,4,3]
//[5,6,4]
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int flag = 0;
        int temp = 0;
        ListNode node = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            temp = 0;
            temp += stack1.isEmpty() ? 0 : stack1.pop();
            temp += stack2.isEmpty() ? 0 : stack2.pop();
            temp += flag;
            if (temp > 9) {
                flag = 1;
                temp = temp - 10;
            } else {
                flag = 0;
            }
            node = new ListNode(temp, node);
        }
        if (flag == 1) {
            node = new ListNode(1, node);
        }
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}