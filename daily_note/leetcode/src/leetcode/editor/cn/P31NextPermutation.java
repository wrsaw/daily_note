package leetcode.editor.cn;

//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1276 👎 0

public class P31NextPermutation{
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        int[] nums = new int[]{2,3,1,3,3};
        solution.nextPermutation(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //从右往左找出第一个降序出现的位置x
        //从x往右找出比x大的最小的数y
        //x和y交换顺序
        //把x右面的序列按从小到大排序
        public void nextPermutation(int[] nums) {
            if (nums.length == 1) {
                return;
            }
            int x = -1, y = -1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    x = i;
                    break;
                }
            }
            if (x >= 0) {
                for (int i = x + 1; i < nums.length; i++) {
                    if (nums[i] > nums[x] && (y < 0 || nums[i] <= nums[y])) {
                        y = i;
                    }
                }
                swap(nums, x, y);
            }
            //x右边的序列一定是升序的
            int left = x + 1;
            int right = nums.length - 1;
            while (left < right) {
                swap(nums, left++, right--);
            }
        }

        private void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}