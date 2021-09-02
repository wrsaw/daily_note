package leetcode.editor.cn;

//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1147 👎 0

public class P45JumpGameIi{
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //贪心算法，每走一步必须为当前能到达的最大距离
        public int jump(int[] nums) {
            //目前已能达到的最大距离
            int maxP = 0;
            //已用步数
            int steps = 0;
            //上一步走完已到达的位置
            int lastEnd = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                //循环更新目前能到达的最大位置
                maxP = Math.max(maxP, i + nums[i]);
                //走到上一步已到达的位置后，必须增加步数才能增加距离
                if (i == lastEnd) {
                    steps++;
                    //这次走完的位置更新为目前能到达的最大距离
                    lastEnd = maxP;
                }
            }
            return steps;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}