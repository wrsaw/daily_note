package leetcode.editor.cn;

//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心 递归 字符串 动态规划 
// 👍 738 👎 0

public class P44WildcardMatching{
    public static void main(String[] args) {
        Solution solution = new P44WildcardMatching().new Solution();
        System.out.println(solution.isMatch("",""));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 1; i <= m; i++) {
            f[i][0] = false;
        }
        if (p.length() > 0) {
            f[0][1] = p.charAt(0) == '*';
        }
        for (int j = 1; j <= n; j++) {
            f[0][j] = p.charAt(j - 1) == '*' && f[0][j - 1];
        }
        for (int i = 1; i <= m; i++) {
            char sc = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if ('?' == pc) {
                    f[i][j] = f[i - 1][j - 1];
                } else if ('*' == pc) {
                    f[i][j] = f[i][j - 1] || f[i - 1][j];
                } else {
                    if (sc == pc) {
                        f[i][j] = f[i - 1][j - 1];
                    } else {
                        f[i][j] = false;
                    }
                }
            }
        }
        return f[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}