package leetcode.editor.cn;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2923 👎 0

public class P7ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        System.out.println(solution.reverse(123));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        long y = x;
        y = y > 0 ? y : 0 - y;
        if (y == 0) {
            return 0;
        }
        int[] arr = new int[10];
        int temp = 0;
        int num = 0;
        while (y / 10 > 0) {
            arr[temp++] = (int)(y % 10);
            num++;
            y = y / 10;
        }
        arr[temp] = (int)y;
        num++;
        long res = 0;
        int p = num;
        for (int i = 0; i < num; i++) {
            res += arr[i] * (long)Math.pow(10, --p);
        }
        return (int)(x > 0 ? (res > Integer.MAX_VALUE ? 0 : res) : ((0 - res) < Integer.MIN_VALUE ? 0 : 0 - res));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}