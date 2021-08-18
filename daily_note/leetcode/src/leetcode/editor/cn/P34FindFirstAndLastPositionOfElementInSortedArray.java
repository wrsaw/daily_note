package leetcode.editor.cn;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1154 👎 0

public class P34FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] arr = new int[]{3,3,3};
        System.out.println(solution.searchRange(arr, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //二分：保证不把相同的内容截到两侧，可以通过，代码很冗长
        //官方答案为两次二分，查第一个大于等于target和第一个大于target的位置
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            if (nums.length == 0) {
                result[0] = result[1] = -1;
                return result;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                if (left == right) {
                    if (nums[left] == target) {
                        result[0] = result[1] = left;
                        return result;
                    } else {
                        result[0] = result[1] = -1;
                        return result;
                    }
                } else if (left == right - 1) {
                    if (nums[left] == target && nums[right] == target) {
                        result[0] = left;
                        result[1] = right;
                        return result;
                    } else if (nums[left] == target) {
                        result[0] = result[1] = left;
                        return result;
                    } else if (nums[right] == target) {
                        result[0] = result[1] = right;
                        return result;
                    } else {
                        result[0] = result[1] = -1;
                        return result;
                    }
                } else {
                    if (target < nums[left] || target > nums[right]) {
                        result[0] = result[1] = -1;
                        return result;
                    } else {
                        if (nums[left] == nums[right]) {
                            if (nums[left] == target) {
                                result[0] = left;
                                result[1] = right;
                                return result;
                            } else {
                                result[0] = result[1] = -1;
                                return result;
                            }
                        } else {
                            int middle = (left + right) / 2;
                            boolean falg = false;
                            while (nums[middle] == nums[middle + 1]) {
                                if (nums[left] != nums[middle]) {
                                    falg = true;
                                    middle--;
                                } else {
                                    middle++;
                                }
                            }
                            if (falg) {
                                middle++;
                            }
                            if (nums[middle] > target) {
                                right = middle;
                            } else if (nums[middle] < target) {
                                left = middle;
                            } else {
                                if (falg) {
                                    left = middle;
                                } else {
                                    right = middle;
                                }
                            }
                        }
                    }
                }
            }
            result[0] = result[1] = -1;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}