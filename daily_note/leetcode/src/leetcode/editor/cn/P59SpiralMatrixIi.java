package leetcode.editor.cn;

//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 541 👎 0

import java.util.Arrays;

public class P59SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int total = n * n;
        int[][] op = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0;
        int x = 0;
        int y = 0;
        int nextx;
        int nexty;
        int num = 1;
        ans[0][0] = num++;
        while (num <= total) {
            nextx = x + op[i][0];
            nexty = y + op[i][1];
            if (nextx >= n || nextx < 0 || nexty >= n || nexty < 0 || ans[nextx][nexty] > 0) {
                i++;
                if (i > 3) {
                    i = 0;
                }
                nextx = x + op[i][0];
                nexty = y + op[i][1];
            }
            x = nextx;
            y = nexty;
            ans[x][y] = num++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}