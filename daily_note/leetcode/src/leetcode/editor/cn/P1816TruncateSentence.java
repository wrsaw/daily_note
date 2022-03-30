package leetcode.editor.cn;

//句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。 
//
// 
// 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。 
// 
//
// 给你一个句子 s 和一个整数 k ，请你将 s 截断 ，使截断后的句子仅含 前 k 个单词。返回 截断 s 后得到的句子。 
//
// 
//
// 示例 1： 
//
// 输入：s = "Hello how are you Contestant", k = 4
//输出："Hello how are you"
//解释：
//s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
//前 4 个单词为 ["Hello", "how", "are", "you"]
//因此，应当返回 "Hello how are you"
// 
//
// 示例 2： 
//
// 输入：s = "What is the solution to this problem", k = 4
//输出："What is the solution"
//解释：
//s 中的单词为 ["What", "is" "the", "solution", "to", "this", "problem"]
//前 4 个单词为 ["What", "is", "the", "solution"]
//因此，应当返回 "What is the solution" 
//
// 示例 3： 
//
// 输入：s = "chopper is not a tanuki", k = 5
//输出："chopper is not a tanuki"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// k 的取值范围是 [1, s 中单词的数目] 
// s 仅由大小写英文字母和空格组成 
// s 中的单词之间由单个空格隔开 
// 不存在前导或尾随空格 
// 
// Related Topics 数组 字符串 
// 👍 30 👎 0

public class P1816TruncateSentence{
    public static void main(String[] args) {
        Solution solution = new P1816TruncateSentence().new Solution();
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String truncateSentence(String s, int k) {
        /*String[] arr = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (i > 0) {
                builder.append(" ");
            }
            builder.append(arr[i]);
        }
        return builder.toString();*/

        int i = 0;
        while (i < s.length() && k > 0) {
            if (s.charAt(i) == ' ') {
                k--;
            }
            i++;
        }
        if (i != s.length()) {
            i--;
        }
        return s.substring(0, i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}