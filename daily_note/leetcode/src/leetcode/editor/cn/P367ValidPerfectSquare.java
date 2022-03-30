package leetcode.editor.cn;

//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 291 👎 0

public class P367ValidPerfectSquare{
    public static void main(String[] args) {
        Solution solution = new P367ValidPerfectSquare().new Solution();
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        int le = 0;
        int ri = num;
        long m;
        while (le <= ri) {
            int temp = (ri - le) / 2 + le;
            m = (long) temp * temp;
            if (m == num) {
                return true;
            } else if (m > num) {
                ri = temp - 1;
            } else {
                le = temp + 1;
            }
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}