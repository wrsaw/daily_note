package leetcode.editor.cn;

//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 707 👎 0

public class P43MultiplyStrings{
    public static void main(String[] args) {
        Solution solution = new P43MultiplyStrings().new Solution();
        System.out.println(solution.multiply("123", "456"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        //mum1和num2相乘结果为m+n或m+n-1位
        int[] ans = new int[m + n];
        int index = m + n - 1;
        int tempm, temp;
        int tempa = 0;
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                tempm = x * y + tempa + ans[index];
                temp = tempm % 10;
                ans[index--] = temp;
                tempa = tempm / 10;
            }
            if (tempa > 0) {
                ans[index] = tempa;
            }
            index = m + n - 1 - (m - i);
            tempa = 0;
        }
        StringBuilder builder = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < ans.length; i++) {
            if (flag && ans[i] == 0) {
                continue;
            }
            flag = false;
            builder.append(ans[i]);
        }
        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}