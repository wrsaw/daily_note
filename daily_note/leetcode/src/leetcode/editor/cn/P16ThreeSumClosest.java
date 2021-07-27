package leetcode.editor.cn;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 排序 
// 👍 833 👎 0

import java.util.Arrays;

public class P16ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = -1;
        int res = 0;
        int total;
        int sub;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (true) {
                total = nums[i] + nums[j] + nums[k];
                sub = total > target ? total - target : target - total;
                if (sub == 0) {
                    return total;
                }
                if (min == -1 || sub < min) {
                    min = sub;
                    res = total;
                }
                if (nums[i] + nums[j] + nums[k] - target > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] - target < 0) {
                    j++;
                }
                if (j >= k) {
                    break;
                }
            }
        }
        return res;

        /*Arrays.sort(nums);
        int min = -1;
        int res = 0;
        int total;
        int sub;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    total = nums[i] + nums[j] + nums[k];
                    sub = total > target ? total - target : target - total;
                    if (sub == 0) {
                        return total;
                    }
                    if (min == -1 || sub < min) {
                        min = sub;
                        res = total;
                    }
                }
            }
        }
        return res;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}