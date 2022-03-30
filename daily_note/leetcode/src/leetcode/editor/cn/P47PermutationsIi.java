package leetcode.editor.cn;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 
// 👍 798 👎 0

import java.util.*;

public class P47PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            //Arrays.sort(nums); 或者排序比较每一次回溯后跟上一次的状态也可以
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            boolean[] ex = new boolean[nums.length];
            handle(nums, ans, temp, ex, 0);
            return ans;
        }

        private void handle(int[] nums, List<List<Integer>> ans, List<Integer> temp, boolean[] ex, int n) {
            if (n == nums.length) {
                ans.add(new ArrayList<>(temp));
                return;
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i]) || ex[i]) {
                    continue;
                }
                ex[i] = true;
                set.add(nums[i]);
                temp.add(nums[i]);
                handle(nums, ans, temp, ex, n + 1);
                ex[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}