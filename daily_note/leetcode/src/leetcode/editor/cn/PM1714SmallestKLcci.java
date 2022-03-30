package leetcode.editor.cn;

//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 119 👎 0

import java.util.Arrays;
import java.util.PriorityQueue;

public class PM1714SmallestKLcci{
    public static void main(String[] args) {
        Solution solution = new PM1714SmallestKLcci().new Solution();
        System.out.println(Arrays.toString(solution.smallestK(new int[] {1,3,5,7,2,4,6,8}, 4)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i < arr.length; i++) {
            if (k > 0) {
                queue.add(arr[i]);
                k--;
            } else {
                if (arr[i] < queue.peek()) {
                    queue.add(arr[i]);
                    queue.poll();
                }
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}