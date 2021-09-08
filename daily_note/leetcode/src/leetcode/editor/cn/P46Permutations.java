package leetcode.editor.cn;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1540 👎 0

import java.util.ArrayList;
import java.util.List;

public class P46Permutations{
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();

        System.out.println(solution.permute(new int[]{1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            boolean[] arr = new boolean[nums.length];
            handle(nums, ans, temp, arr, 0);
            return ans;
        }

        private void handle(int[] nums, List<List<Integer>> ans, List<Integer> temp, boolean[] arr, int n) {
            if (n == nums.length) {
                ans.add(new ArrayList<>(temp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!arr[i]) {
                    temp.add(nums[i]);
                    arr[i] = true;
                    handle(nums, ans, temp, arr, n + 1);
                    temp.remove(temp.size() - 1);
                    arr[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}