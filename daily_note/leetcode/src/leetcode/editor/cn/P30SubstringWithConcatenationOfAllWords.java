package leetcode.editor.cn;

//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 520 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P30SubstringWithConcatenationOfAllWords{
    public static void main(String[] args) {
        Solution solution = new P30SubstringWithConcatenationOfAllWords().new Solution();
        String[] words = new String[]{"word","good","best","good"};
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", words));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();
            int wordLength = words[0].length();
            int totalLength = wordLength * words.length;
            if (s.length() < totalLength) {
                return result;
            }
            Map<String, Integer> wordMap = new HashMap<>();
            for (String word : words) {
                wordMap.putIfAbsent(word, 0);
                wordMap.put(word, wordMap.get(word) + 1);
            }
            for (int index = 0; index < wordLength; index++) {
                handle(s, wordMap, index, wordLength, totalLength, result);
            }
            return result;
        }

        private void handle(String s, Map<String, Integer> wordMap, int index, int wordLength, int totalLength, List<Integer> result) {
            Map<String, Integer> map = new HashMap<>();
            int tempRes = index;
            int tempIndex = index;
            String tempString;
            int tempNum;
            String tempString2;
            while (tempRes + totalLength <= s.length()) {
                tempString = s.substring(tempIndex, tempIndex + wordLength);
                if (wordMap.get(tempString) == null) {
                    tempIndex += wordLength;
                    tempRes = tempIndex;
                    map = new HashMap<>();
                } else {
                    tempNum = map.getOrDefault(tempString, 0);
                    if (tempNum + 1 < wordMap.get(tempString)) {
                        map.put(tempString, tempNum + 1);
                    } else if (tempNum + 1 == wordMap.get(tempString)) {
                        map.put(tempString, tempNum + 1);
                        if (tempIndex == tempRes + totalLength - wordLength) {
                            result.add(tempRes);
                        }
                    } else {
                        tempString2 = s.substring(tempRes, tempRes + wordLength);
                        while (!tempString.equals(tempString2)) {
                            map.put(tempString2, map.get(tempString2) - 1);
                            tempRes += wordLength;
                            tempString2 = s.substring(tempRes, tempRes + wordLength);
                        }
                        tempRes += wordLength;
                    }
                    tempIndex += wordLength;
                    if (tempIndex == tempRes + totalLength) {
                        map.put(s.substring(tempRes, tempRes + wordLength), map.get(s.substring(tempRes, tempRes + wordLength)) - 1);
                        tempRes += wordLength;
                    }
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}