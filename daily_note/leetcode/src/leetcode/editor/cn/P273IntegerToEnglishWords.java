package leetcode.editor.cn;

//将非负整数 num 转换为其对应的英文表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 123
//输出："One Hundred Twenty Three"
// 
//
// 示例 2： 
//
// 
//输入：num = 12345
//输出："Twelve Thousand Three Hundred Forty Five"
// 
//
// 示例 3： 
//
// 
//输入：num = 1234567
//输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
// 
//
// 示例 4： 
//
// 
//输入：num = 1234567891
//输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thous
//and Eight Hundred Ninety One"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 231 - 1 
// 
// Related Topics 递归 数学 字符串 
// 👍 195 👎 0


public class P273IntegerToEnglishWords{
    public static void main(String[] args) {
        Solution solution = new P273IntegerToEnglishWords().new Solution();
        
    }
    //TODO 英语不好，直接粘答案了
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};

        public String numberToWords(int num) {
            if (num == 0) {
                return "Zero";
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
                int curNum = num / unit;
                if (curNum != 0) {
                    num -= curNum * unit;
                    sb.append(toEnglish(curNum)).append(thousands[i]).append(" ");
                }
            }
            return sb.toString().trim();
        }

        public String toEnglish(int num) {
            StringBuffer curr = new StringBuffer();
            int hundred = num / 100;
            num %= 100;
            if (hundred != 0) {
                curr.append(singles[hundred]).append(" Hundred ");
            }
            int ten = num / 10;
            if (ten >= 2) {
                curr.append(tens[ten]).append(" ");
                num %= 10;
            }
            if (num > 0 && num < 10) {
                curr.append(singles[num]).append(" ");
            } else if (num >= 10) {
                curr.append(teens[num - 10]).append(" ");
            }
            return curr.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}