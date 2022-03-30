package leetcode.editor.cn;

//给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3], k = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 104 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 106 
// 
//
// 
//
// 注意：本题与主站 713 题相同：https://leetcode-cn.com/problems/subarray-product-less-than-
//k/ 
// Related Topics 数组 滑动窗口 
// 👍 49 👎 0

public class POffer009{
    public static void main(String[] args) {
        Solution solution = new POffer009().new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, left = 0, right = 0;
        int temp = nums[0];
        while (left < nums.length) {
            while (temp < k && right < nums.length - 1 && temp * nums[right + 1] < k) {
                right++;
                temp = temp * nums[right];
            }
            if (temp < k) {
                ans += right - left + 1;
            }
            temp /= nums[left];
            left++;
            if (left < nums.length && left > right) {
                right = left;
                temp = nums[left];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}