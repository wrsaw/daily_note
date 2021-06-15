package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3706 👎 0

public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("ccc"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 1) {
                return s;
            }
            String result = "";
            for (int i = 0; i < s.length() - 1; i++) {
                String temp = getTempResult(s, i);
                if (temp.length() > result.length()) {
                    result = temp;
                }
            }
            return result;
        }

        private String getTempResult(String s, int i) {
            if (i == 0) {
                if (s.charAt(0) == s.charAt(1)) {
                    return s.substring(0, 2);
                }
            }
            String result1 = getTempResult1(s, i);
            String result2 = getTempResult2(s, i);
            return result1.length() > result2.length() ? result1 : result2;
        }
        private String getTempResult1(String s, int i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                int t = 1;
                while (i - t >= 0 && i + 1 + t < s.length() && s.charAt(i - t) == s.charAt(i + 1 + t)) {
                    t++;
                }
                return s.substring(i - t + 1, i + t + 1);
            }
            return s.substring(i, i + 1);
        }
        private String getTempResult2(String s, int i) {
            int t = 1;
            while (i - t >= 0 && i + t < s.length() && s.charAt(i - t) == s.charAt(i + t)) {
                t++;
            }
            return s.substring(i - t + 1, i + t);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}