package leetcode.editor.cn;

//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
// Related Topics 位运算 数学 字符串 模拟 
// 👍 21 👎 0

public class POffer002{
    public static void main(String[] args) {
        Solution solution = new POffer002().new Solution();
        System.out.println(solution.addBinary("1010", "1011"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int temp = 0;
        int index = 0;
        while (index < a.length() && index < b.length()) {
            temp = a.charAt(a.length() - 1 - index) - '0' + b.charAt(b.length() - 1 - index) - '0' + temp;
            if (temp < 2) {
                builder.append(temp);
                temp = 0;
            } else {
                builder.append(temp - 2);
                temp = 1;
            }
            index++;
        }
        while (index < a.length()) {
            temp = a.charAt(a.length() - 1 - index) - '0' + temp;
            if (temp < 2) {
                builder.append(temp);
                temp = 0;
            } else {
                builder.append(temp - 2);
                temp = 1;
            }
            index++;
        }
        while (index < b.length()) {
            temp = b.charAt(b.length() - 1 - index) - '0' + temp;
            if (temp < 2) {
                builder.append(temp);
                temp = 0;
            } else {
                builder.append(temp - 2);
                temp = 1;
            }
            index++;
        }
        if (temp > 0) {
            builder.append("1");
        }
        return builder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}