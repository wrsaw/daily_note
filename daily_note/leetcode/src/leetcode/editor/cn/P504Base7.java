package leetcode.editor.cn;

//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -107 <= num <= 107 
// 
// Related Topics 数学 
// 👍 136 👎 0

public class P504Base7{
    public static void main(String[] args) {
        Solution solution = new P504Base7().new Solution();
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean flag = false;
        StringBuilder ans = new StringBuilder();
        if (num < 0) {
            flag = true;
            num = 0 - num;
        }
        while (num > 0) {
            ans.append(num % 7);
            num = num / 7;
        }
        if (flag) {
            ans.append("-");
        }
        return ans.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}