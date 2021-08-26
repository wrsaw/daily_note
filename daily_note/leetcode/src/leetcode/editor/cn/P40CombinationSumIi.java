package leetcode.editor.cn;

//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 
// 👍 677 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, candidates.length - 1, new ArrayList<>(), result);
            return result;
        }

        private void dfs(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> result) {
            if (target == 0) {
                result.add(new ArrayList<>(list));
                return;
            }
            if (index < 0) {
                return;
            }
            if (target >= candidates[index]) {
                list.add(candidates[index]);
                dfs(candidates, target - candidates[index], index - 1, list, result);
                list.remove(list.size() - 1);
            }
            while (index > 0 && candidates[index] == candidates[index - 1]) {
                index--;
            }
            dfs(candidates, target, index - 1, list, result);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}