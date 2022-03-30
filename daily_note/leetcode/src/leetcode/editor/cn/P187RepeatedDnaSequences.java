package leetcode.editor.cn;

//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。 
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 105 
// s[i] 为 'A'、'C'、'G' 或 'T' 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 
// 👍 249 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P187RepeatedDnaSequences{
    public static void main(String[] args) {
        Solution solution = new P187RepeatedDnaSequences().new Solution();
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() <= 10) {
            return ans;
        }
        Map<String, Integer> map = new HashMap<>();
        String tempStr;
        for (int i = 0; i < s.length() - 9; i++) {
            tempStr = s.substring(i, i + 10);
            map.putIfAbsent(tempStr, 0);
            map.put(tempStr, map.get(tempStr) + 1);
        }
        map.forEach((k,v) -> {
            if (v > 1) {
                ans.add(k);
            }
        });
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}