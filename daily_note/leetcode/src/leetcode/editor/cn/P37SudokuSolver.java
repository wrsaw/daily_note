package leetcode.editor.cn;

//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入：board = [['5','3','.','.','7','.','.','.','.'],['6','.','.','1','9','5','.'
//,'.','.'],['.','9','8','.','.','.','.','6','.'],['8','.','.','.','6','.','.','.'
//,'3'],['4','.','.','8','.','3','.','.','1'],['7','.','.','.','2','.','.','.','6'
//],['.','6','.','.','.','.','2','8','.'],['.','.','.','4','1','9','.','.','5'],['
//.','.','.','.','8','.','.','7','9']]
//输出：[['5','3','4','6','7','8','9','1','2'],['6','7','2','1','9','5','3','4','8'
//],['1','9','8','3','4','2','5','6','7'],['8','5','9','7','6','1','4','2','3'],['
//4','2','6','8','5','3','7','9','1'],['7','1','3','9','2','4','8','5','6'],['9','
//6','1','5','3','7','2','8','4'],['2','8','7','4','1','9','6','3','5'],['3','4','
//5','2','8','6','1','7','9']]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 数组 回溯 矩阵 
// 👍 913 👎 0

import java.util.*;

public class P37SudokuSolver{
    public static void main(String[] args) {
        Solution solution = new P37SudokuSolver().new Solution();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //每一行存在的数字，row[m][n]为true表示第m行已存在数字n+1
        private boolean[][] row = new boolean[9][9];
        //每一列存在的数字，col[m][n]为true表示第m列已存在数字n+1
        private boolean[][] col = new boolean[9][9];
        //每一个3x3矩阵存在的数字，tab[m][n][p]为true表示第m行第n列的矩阵已存在数字p+1
        private boolean[][][] tab = new boolean[3][3][9];
        //保存board空白节点信息
        private List<int[]> spaceList = new ArrayList<>();
        //是否已得出最终解
        private boolean flag = false;

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        spaceList.add(new int[]{i, j});
                    } else {
                        int digit = board[i][j] - '0' - 1;
                        row[i][digit] = col[j][digit] = tab[i / 3][j / 3][digit] = true;
                    }
                }
            }

            dfs(board, 0);

        }

        /*{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}*/
        private void dfs(char[][] board, int index) {
            if (index == spaceList.size()) {
                flag = true;
                return;
            }
            int i = spaceList.get(index)[0];
            int j = spaceList.get(index)[1];
            for (int num = 0; num < 9 && !flag; num++) {
                if (!row[i][num] && !col[j][num] && !tab[i / 3][j / 3][num]) {
                    row[i][num] = col[j][num] = tab[i / 3][j / 3][num] = true;
                    board[i][j] = (char) ('0' + num + 1);
                    dfs(board, index + 1);
                    row[i][num] = col[j][num] = tab[i / 3][j / 3][num] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}