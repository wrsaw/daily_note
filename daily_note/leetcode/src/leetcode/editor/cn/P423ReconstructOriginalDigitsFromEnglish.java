package leetcode.editor.cn;

//给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "owoztneoer"
//输出："012"
// 
//
// 示例 2： 
//
// 
//输入：s = "fviefuro"
//输出："45"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一 
// s 保证是一个符合题目要求的字符串 
// 
// Related Topics 哈希表 数学 字符串 
// 👍 136 👎 0

import java.util.*;

public class P423ReconstructOriginalDigitsFromEnglish{
    public static void main(String[] args) {
        Solution solution = new P423ReconstructOriginalDigitsFromEnglish().new Solution();
        System.out.println(solution.originalDigits("owoztneoer"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        // 优化：使用数组保存出现每个数字的次数，最后不需要在排序；
        // 直接计算特征字母出现的次数，之后的数字使用特征字符出现次数进去之前计算过的数字，不需要处理原map
        public String originalDigits(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int length = s.length();
            for (int i = 0; i < s.length(); i++) {
                map.putIfAbsent(s.charAt(i), 0);
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }

            Map<Character, List<Character>> aMap = new LinkedHashMap<>();
            aMap.put('z', Arrays.asList('0', 'z', 'e', 'r', 'o'));
            aMap.put('w', Arrays.asList('2', 't', 'w', 'o'));
            aMap.put('u', Arrays.asList('4', 'f', 'o', 'u', 'r'));
            aMap.put('x', Arrays.asList('6', 's', 'i', 'x'));
            aMap.put('g', Arrays.asList('8', 'e', 'i', 'g', 'h', 't'));
            aMap.put('o', Arrays.asList('1', 'o', 'n', 'e'));
            aMap.put('t', Arrays.asList('3', 't', 'h', 'r', 'e', 'e'));
            aMap.put('s', Arrays.asList('7', 's', 'e', 'v', 'e', 'n'));
            aMap.put('f', Arrays.asList('5', 'f', 'i', 'v', 'e'));
            aMap.put('n', Arrays.asList('9', 'n', 'i', 'n', 'e'));

            List<Character> list = new ArrayList<>();
            while (length > 0) {
                for (Map.Entry<Character, List<Character>> entry : aMap.entrySet()) {
                    if (map.containsKey(entry.getKey()) && map.get(entry.getKey()) > 0) {
                        list.add(entry.getValue().get(0));
                        length -= (entry.getValue().size() - 1);
                        for (int i = 1; i < entry.getValue().size(); i++) {
                            map.put(entry.getValue().get(i), map.get(entry.getValue().get(i)) - 1);
                        }
                        break;
                    }
                }
            }
            list.sort(Character::compareTo);

            StringBuilder builder = new StringBuilder();
            list.forEach(builder::append);
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}