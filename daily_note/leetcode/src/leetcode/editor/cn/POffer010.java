package leetcode.editor.cn;

//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2
//解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
// 
//
// 示例 2 : 
//
// 
//输入:nums = [1,2,3], k = 3
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -1000 <= nums[i] <= 1000 
// 
// -107 <= k <= 107 
// 
// 
//
// 
//
// 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/ 
// Related Topics 数组 哈希表 前缀和 
// 👍 49 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class POffer010{
    public static void main(String[] args) {
        Solution solution = new POffer010().new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] arr = new int[nums.length];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(i);
            arr[i] = temp;
        }

        int ans = 0;
        int tempK = k;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                tempK = k + arr[i - 1];
            }
            if (map.get(tempK) != null) {
                for (int t : map.get(tempK)) {
                    if (t >= i) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}