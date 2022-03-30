package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 1925 👎 0

import java.util.ArrayList;
import java.util.List;

public class P22GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        //方法一：暴力
        /*public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            char[] arr = new char[2 * n];
            generate(arr, 0, n, result);
            return result;
        }

        private void generate(char[] arr, int i, int n, List<String> result) {
            if (i == 2 * n) {
                if (check(arr)) {
                    result.add(String.valueOf(arr));
                }
            } else {
                arr[i] = '(';
                generate(arr, i + 1, n, result);
                arr[i] = ')';
                generate(arr, i + 1, n, result);
            }
        }


        private boolean check(char[] arr) {
            int left = 0;
            int right = 0;
            for (char c : arr) {
                if ('(' == c) {
                    left++;
                } else if (')' == c) {
                    right++;
                }
                if (right > left) {
                    return false;
                }
            }
            return left == right;
        }*/

        /*//方法二：回溯
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            track(result, new StringBuilder(), 0, 0, n);
            return result;
        }

        private void track(List<String> result, StringBuilder builder, int left, int right, int max) {
            if (builder.length() == 2 * max) {
                result.add(builder.toString());
                return;
            }

            if (left < max) {
                builder.append("(");
                track(result, builder, left + 1, right, max);
                builder.deleteCharAt(builder.length() - 1);
            }

            if (right < left) {
                builder.append(")");
                track(result, builder, left, right + 1, max);
                builder.deleteCharAt(builder.length() - 1);
            }
        }*/

        //方法三：递归
        ArrayList[] cache = new ArrayList[100];
        public List<String> generateParenthesis(int n) {
            return generate(n);
        }

        private List<String> generate(int n) {
            if (cache[n] != null) {
                return cache[n];
            }
            ArrayList<String> list = new ArrayList<>();
            if (n == 0) {
                list.add("");
            } else {
                for (int i = 0; i < n; i++) {
                    for (int p = 0; p < generate(i).size(); p++) {
                        for (int q = 0; q < generate(n - i - 1).size(); q++) {
                            list.add("(" + generate(i).get(p) + ")" + generate(n - i - 1).get(q));
                        }
                    }
                }
            }
            cache[n] = list;
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}