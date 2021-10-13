package leetcode.editor.cn;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 1137 👎 0

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class P56MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        System.out.println(solution.merge(new int[][]{{1,4},{1,5}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        //可以直接用Arrays.sort()排序数组
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            map.put(interval[0], Math.max(interval[1], map.getOrDefault(interval[0], 0)));
        }
        int index = 0;
        int[][] ans = new int[intervals.length][2];
        int begin = 0;
        int end = 0;
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (i == 0) {
                begin = entry.getKey();
                end = entry.getValue();
                i++;
                continue;
            }
            if (entry.getKey() > end) {
                ans[index] = new int[]{begin, end};
                begin = entry.getKey();
                end = entry.getValue();
                index++;
            } else {
                if (entry.getValue() > end) {
                    end = entry.getValue();
                }
            }
            i++;
        }
        ans[index] = new int[]{begin, end};

        return Arrays.copyOfRange(ans, 0, index + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}