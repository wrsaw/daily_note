package leetcode.editor.cn;

//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯 
// 👍 296 👎 0

public class P52NQueensIi{
    public static void main(String[] args) {
        Solution solution = new P52NQueensIi().new Solution();
        System.out.println(solution.totalNQueens(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalNQueens(int n) {
            boolean[] col = new boolean[n];
            boolean[] le = new boolean[2 * n - 1];
            boolean[] ri = new boolean[2 * n - 1];

            return handle(n, col, le, ri, 0);
        }

        private int handle(int n, boolean[] col, boolean[] le, boolean[] ri, int num) {
            if (num == n) {
                return 1;
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (col[i] || le[num + i] || ri[i - num + n - 1]) {
                    continue;
                }
                col[i] = le[num + i] = ri[i - num + n - 1] = true;
                count += handle(n, col, le, ri, num + 1);
                col[i] = le[num + i] = ri[i - num + n - 1] = false;
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}