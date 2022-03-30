package leetcode.editor.cn;

//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。 
//
// 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 
// 👍 221 👎 0

import java.util.Arrays;
import java.util.List;

public class P524LongestWordInDictionaryThroughDeleting{
    public static void main(String[] args) {
        Solution solution = new P524LongestWordInDictionaryThroughDeleting().new Solution();
        List<String> list = Arrays.asList("apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf");
        System.out.println(solution.findLongestWord("aewfafwafjlwajflwajflwafj", list));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            dictionary.sort((s1, s2) -> {
                if (s1.length() < s2.length()) {
                    return 1;
                }
                if (s1.length() > s2.length()) {
                    return -1;
                }
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) == s2.charAt(i)) {
                        continue;
                    }
                    return s1.charAt(i) - s2.charAt(i);
                }
                return 0;
            });

            for (String str : dictionary) {
                if (handle(s, str)) {
                    return str;
                }
            }
            return "";
        }

        private boolean handle(String s, String str) {
            int i1 = 0, i2 = 0;
            while (i1 < s.length() && i2 < str.length()) {
                if (s.length() - i1 < str.length() - i2) {
                    return false;
                }
                if (s.charAt(i1) == str.charAt(i2)) {
                    i1++;
                    i2++;
                } else {
                    i1++;
                }
            }
            return i2 == str.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}