package leetcode.editor.cn;

//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯 
// 👍 1019 👎 0

import java.util.ArrayList;
import java.util.List;

public class P51NQueens{
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        System.out.println(solution.solveNQueens(4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            boolean[] row = new boolean[n];
            boolean[] col = new boolean[n];
            boolean[] le = new boolean[2 * n - 1];
            boolean[] ri = new boolean[2 * n - 1];

            List<List<String>> ans = new ArrayList<>();
            List<String> temp = null;
            StringBuilder builder = null;
            handle(ans, n, row, col, le, ri, temp, 0, 0, builder, 0);
            return ans;
        }

        //TODO 可以优化成按每一行中放置皇后的位置回溯，不用一格一格回溯
        private void handle(List<List<String>> ans, int n, boolean[] row, boolean[] col, boolean[] le, boolean[] ri,
                            List<String> temp, int x, int y, StringBuilder builder, int num) {
            if (x == n) {
                if (num == n) {
                    ans.add(new ArrayList<>(temp));
                }
                return;
            }
            if (y == 0) {
                if (x == 0) {
                    temp = new ArrayList<>();
                }
                builder = new StringBuilder();
            }
            for (int k = 0; k < 2; k++) {
                int ox = x;
                int oy = y;
                if (k == 0) {
                    builder.append('.');
                    y++;
                    if (y >= n) {
                        y = 0;
                        x++;
                        temp.add(builder.toString());
                    }
                    if (y != 0 || num == x) {
                        handle(ans, n, row, col, le, ri, temp, x, y, builder, num);
                    }
                } else {
                    if (row[x] || col[y] || le[x + y] || ri[y - x + n - 1]) {
                        continue;
                    }
                    builder.append('Q');
                    row[x] = col[y] = le[x + y] = ri[y - x + n - 1] = true;
                    y++;
                    if (y >= n) {
                        y = 0;
                        x++;
                        temp.add(builder.toString());
                        if (num != x - 1) {
                            return;
                        }
                    }
                    handle(ans, n, row, col, le, ri, temp, x, y, builder, num + 1);
                    row[ox] = col[oy] = le[oy + ox] = ri[oy - ox + n - 1] = false;
                }
                builder.deleteCharAt(builder.length() - 1);
                if (y == 0) {
                    temp.remove(temp.size() - 1);
                }
                x = ox;
                y = oy;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}