package leetcode.editor.cn;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 880 👎 0

import java.util.ArrayList;
import java.util.List;

public class P54SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int x = 0;
        int y = 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int state = 0;

        int[][] stateArr = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        boolean[][] arr = new boolean[m][n];

        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[x][y]);
            arr[x][y] = true;
            int nx = x + stateArr[state][0];
            int ny = y + stateArr[state][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !arr[nx][ny]) {
                x = nx;
                y = ny;
            } else {
                state++;
                if (state == 4) {
                    state = 0;
                }
                x += stateArr[state][0];
                y += stateArr[state][1];
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}