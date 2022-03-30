package leetcode.editor.cn;

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 
// 👍 1409 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class P32LongestValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P32LongestValidParentheses().new Solution();
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //方法一：栈
        //因为要处理边界问题，不能使用括号入栈，只能记录位置
        /*public int longestValidParentheses(String s) {
            if (s.length() <= 1) {
                return 0;
            }
            Deque<Integer> stack = new LinkedList<>();
            stack.push(-1);
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                if ('(' == s.charAt(i)) {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        result = Math.max(result, i - stack.peek());
                    }
                }
            }
            return result;
        }*/

        //方法二：循环，正逆向结合
        //为解决类似"(()"情况，需要逆向遍历一次
        public int longestValidParentheses(String s) {
            int left = 0;
            int right = 0;
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                if ('(' == s.charAt(i)) {
                    left++;
                } else if (')' == s.charAt(i)) {
                    right++;
                    if (right == left) {
                        result = Math.max(result, left * 2);
                    } else if (right > left) {
                        left = right = 0;
                    }
                }
            }
            left = 0;
            right = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (')' == s.charAt(i)) {
                    right++;
                } else if ('(' == s.charAt(i)) {
                    left++;
                    if (right == left) {
                        result = Math.max(result, right * 2);
                    } else if (right < left) {
                        left = right = 0;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}