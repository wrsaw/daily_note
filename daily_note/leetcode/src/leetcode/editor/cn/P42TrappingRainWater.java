package leetcode.editor.cn;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2631 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class P42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //方法一：循环
        //计算每一个位置左边和右边的最高值
        //该位置可以放的数即为两边最高值中较小的一个和当前位置高度的差
        /*public int trap(int[] height) {
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];
            leftMax[0] = height[0];
            for (int i = 1; i < leftMax.length; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
            rightMax[height.length - 1] = height[height.length - 1];
            for (int i = height.length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
            int result = 0;
            for (int i = 1; i < height.length - 1; i++) {
                result += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return result;
        }*/

        //方法二：栈
        //栈里保存元素的下标，计算放水量需要同时用到元素间距离和高度差
        //从左到右遍历，元素递减时，遍历到的地方通过已有元素一定无法放水，入栈
        //当前元素大于栈顶元素时，栈内元素只有一个时，无发放水，栈内已有元素出栈，当前元素入栈
        //当前元素大于栈顶元素,且栈内元素大于或等于两个时，可以放水，放水数量为栈顶元素两边位置可以放的数量，
        //即当前元素和栈顶元素前一个的距离与高度较小值的乘积
        public int trap(int[] height) {
            Deque<Integer> stack = new LinkedList<>();
            int result = 0;
            for (int i = 0; i < height.length; i++) {
                if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                    stack.push(i);
                } else {
                    if (stack.size() == 1) {
                        stack.pop();
                        stack.push(i);
                    } else {
                        int temp;
                        while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                            temp = stack.pop();
                            if (!stack.isEmpty()) {
                                result += (Math.min(height[stack.peek()], height[i]) - height[temp]) * (i - stack.peek() - 1);
                            }
                        }
                        stack.push(i);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}