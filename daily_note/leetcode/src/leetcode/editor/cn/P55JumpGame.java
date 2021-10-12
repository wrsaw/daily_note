package leetcode.editor.cn;

//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1428 👎 0

public class P55JumpGame{
    public static void main(String[] args) {
        Solution solution = new P55JumpGame().new Solution();
        System.out.println(solution.canJump(new int[]{1,2,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canJump(int[] nums) {
            //记录每一个位置可以到达的最远距离
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (i <= max) {
                    max = Math.max(max, nums[i] + i);
                    if (max >= nums.length - 1) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            return true;

            //从后往前递归是否可以到达终点
            /*boolean[] arr = new boolean[nums.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                arr[i] = handle(nums, arr, i);
            }
            return arr[0];
        }

        private boolean handle(int[] nums, boolean[] arr, int n) {
            if (nums[n] + n >= nums.length - 1) {
                return true;
            }
            if (nums[n] == 0) {
                return false;
            }
            for (int i = 1; i <= nums[n]; i++) {
                if (arr[n + i]) {
                    return true;
                }
            }
            return false;*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}