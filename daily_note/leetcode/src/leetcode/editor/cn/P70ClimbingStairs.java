package leetcode.editor.cn;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 2216 👎 0

import java.util.HashMap;
import java.util.Map;

public class P70ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Integer, Integer> map = new HashMap<>();

        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            map.put(0, 1);
            map.put(1, 1);
            for (int i = 2; i <= n; i++) {
                map.put(i, map.get(i - 1) + map.get(i - 2));
            }
            return map.get(n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}