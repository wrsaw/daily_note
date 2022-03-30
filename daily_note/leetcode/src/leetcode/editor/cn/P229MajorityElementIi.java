package leetcode.editor.cn;

//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：[3] 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：[1,1,1,3,3,2,2,2]
//输出：[1,2] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// -109 <= nums[i] <= 109 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 
// Related Topics 数组 哈希表 计数 排序 
// 👍 442 👎 0

import java.util.*;

public class P229MajorityElementIi{
    public static void main(String[] args) {
        Solution solution = new P229MajorityElementIi().new Solution();
        solution.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //方法一：哈希
        /*List<Integer> ans = new ArrayList<>();
        int temp = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(num, 0) == temp) {
                ans.add(num);
            }
            if (map.getOrDefault(num, 0) <= temp) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return ans;*/

        //方法二：摩尔投票（互相抵消）
        //超出数组三分之一的元素，最多只有两个
        int e1 = 0;
        int e2 = 0;
        int v1 = 0;
        int v2 = 0;
        //选择两个元素，出现第三个元素时，抵消前两个
        //满足结果的元素抵消后数量一定大于0
        for (int num : nums) {
            if (num == e1) {
                v1++;
            } else if (num == e2) {
                v2++;
            } else if (v1 == 0) {
                e1 = num;
                v1++;
            } else if (v2 == 0) {
                e2 = num;
                v2++;
            } else {
                v1--;
                v2--;
            }
        }

        //判断剩下的元素数量是否满足要求
        int n1 = 0;
        int n2 = 0;
        if (v1 > 0 || v2 > 0) {
            for (int num : nums) {
                if (v1 > 0 && num == e1) {
                    n1++;
                }
                if (v2 > 0 && num == e2) {
                    n2++;
                }
            }
        }


        List<Integer> ans = new ArrayList<>();
        if (n1 > nums.length / 3) {
            ans.add(e1);
        }
        if (n2 > nums.length / 3) {
            ans.add(e2);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}