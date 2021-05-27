package leetcode.editor.cn;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 4118 👎 0

public class P4MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        int[] num1 = new int[]{1,2};
        int[] num2 = new int[]{3,4};
        System.out.println(solution.findMedianSortedArrays(num1, num2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            //TODO 二分查找
            return 0;

            //暴力解决
            /*int length = nums1.length + nums2.length;
            if (length == 0) {
                return 0;
            }
            if (length == 1) {
                if (nums1.length > 0) {
                    return nums1[0];
                } else {
                    return nums2[0];
                }
            }
            int i1 = 0, i2 = 0, v1 = 0, v2 = 0;
            for (int i = 1; i <= length / 2 + 1; i++) {
                if (i1 >= nums1.length) {
                    if (i == (length + 1) / 2) {
                        v1 = nums2[i2];
                    } else if (i == (length + 1) / 2 + 1) {
                        v2 = nums2[i2];
                    }
                    i2++;
                } else if (i2 >= nums2.length) {
                    if (i == (length + 1) / 2) {
                        v1 = nums1[i1];
                    } else if (i == (length + 1) / 2 + 1) {
                        v2 = nums1[i1];
                    }
                    i1++;
                } else {
                    if (nums1[i1] < nums2[i2]) {
                        if (i == (length + 1) / 2) {
                            v1 = nums1[i1];
                        } else if (i == (length + 1) / 2 + 1) {
                            v2 = nums1[i1];
                        }
                        i1++;
                    } else {
                        if (i == (length + 1) / 2) {
                            v1 = nums2[i2];
                        } else if (i == (length + 1) / 2 + 1) {
                            v2 = nums2[i2];
                        }
                        i2++;
                    }
                }
            }
            if (length % 2 == 1) {
                return v1;
            }
            return (double) (v1 + v2) / 2;*/
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}