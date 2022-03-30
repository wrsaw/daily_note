package leetcode.editor.cn;

//可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
// 
// 'A'：Absent，缺勤 
// 'L'：Late，迟到 
// 'P'：Present，到场 
// 
//
// 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励： 
//
// 
// 按 总出勤 计，学生缺勤（'A'）严格 少于两天。 
// 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。 
// 
//
// 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 
//取余 的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：8
//解释：
//有 8 种长度为 2 的记录将被视为可奖励：
//"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL" 
//只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：n = 10101
//输出：183236316
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 105 
// 
// Related Topics 动态规划 
// 👍 180 👎 0

public class P552StudentAttendanceRecordIi{
    public static void main(String[] args) {
        Solution solution = new P552StudentAttendanceRecordIi().new Solution();
        System.out.println(solution.checkRecord(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int checkRecord(int n) {
            int mod = 1000000007;
            //为迭代计算结果，需要记录截止到前一天能获取奖励的同时缺勤的天数及最后连续迟到的天数
            //dp[n][i][j]保存第n天，i个缺勤，j个最后连续迟到，并且能获取到奖励的天数
            int[][][] dp = new int[n + 1][2][3];
            //n=0时，i和j必定也为0
            dp[0][0][0] =1;
            //迭代计算n天的结果
            for (int a = 1; a <= n; a++) {
                //若当天为P,当前缺勤可能为0,1,最后连续迟到一定为0，之前缺勤可能为0或1，连续迟到可能为0,1，2
                for (int b = 0; b <= 1; b++) {
                    for (int c = 0; c <= 2; c++) {
                        dp[a][b][0] += dp[a - 1][b][c];
                        dp[a][b][0] %= mod;
                    }
                }

                //若当天为A,当前缺勤一定为1，最后连续迟到一定为0，之前缺勤一定为0，连续迟到可能为0,1,2
                for (int c = 0; c <= 2; c++) {
                    dp[a][1][0] += dp[a - 1][0][c];
                    dp[a][1][0] %= mod;
                }

                //若当天为L，当前缺勤可能为0,1，最后连续迟到可能为1,2，之前缺勤与现在一致，连续迟到比当前少1
                for (int b = 0; b <= 1; b++) {
                    for (int c = 1; c <= 2; c++) {
                        dp[a][b][c] += dp[a - 1][b][c - 1];
                        dp[a][b][c] %= mod;
                    }
                }
            }

            //累加当前天可能出现的所有A和L情况
            int sum = 0;
            for (int b = 0; b <= 1; b++) {
                for (int c = 0; c <= 2; c++) {
                    sum = (sum + dp[n][b][c]) % mod;
                }
            }
            return sum;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}