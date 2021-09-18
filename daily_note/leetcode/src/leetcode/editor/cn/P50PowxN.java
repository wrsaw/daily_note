package leetcode.editor.cn;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 递归 数学 
// 👍 740 👎 0

import java.util.HashMap;
import java.util.Map;

public class P50PowxN{
    public static void main(String[] args) {
        Solution solution = new P50PowxN().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Integer, Double> map = new HashMap<>();
        public double myPow(double x, int n) {
            if (map.get(n) != null) {
                return map.get(n);
            }
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return x;
            }
            if (n == -1) {
                return 1 / x;
            }
            double ans = myPow(x, n / 2) * myPow(x, n - n / 2);
            map.put(n, ans);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}