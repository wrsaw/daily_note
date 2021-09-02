package leetcode.editor.cn;

//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 242 👎 0

public class POffer22LianBiaoZhongDaoShuDiKgeJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new POffer22LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        
    }

   public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //方法一：顺序查找
        public ListNode getKthFromEnd(ListNode head, int k) {
            int total = 0;
            ListNode temp = head;
            while (temp != null) {
                total++;
                temp = temp.next;
            }
            int index = total - k;
            if (index < 0) {
                return null;
            }
            temp = head;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
            return temp;
        }
        //方法二：双指针
    }
//leetcode submit region end(Prohibit modification and deletion)

}