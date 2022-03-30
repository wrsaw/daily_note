package leetcode.editor.cn;

//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 
//
// 示例 3： 
//
// 
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
// 
//
// 示例 4： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
// 
//
// 示例 5： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 105 
// intervals 根据 intervals[i][0] 按 升序 排列 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 105 
// 
// Related Topics 数组 
// 👍 489 👎 0

import java.util.ArrayList;
import java.util.List;

public class P57InsertInterval{
    public static void main(String[] args) {
        Solution solution = new P57InsertInterval().new Solution();
        System.out.println(solution.insert(new int[][]{{1,5}}, new int[]{2, 3}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        List<int[]> list = new ArrayList<>();
        int begin = newInterval[0];
        int end = newInterval[1];
        boolean add = false;
        for (int[] interval : intervals) {
            if (add) {
                list.add(interval);
            } else if (end < interval[0]) {
                list.add(new int[]{begin, end});
                list.add(interval);
                add = true;
            } else if (begin > interval[1]) {
                list.add(interval);
            } else if (begin <= interval[0] && end >= interval[1]) {
            } else if (begin >= interval[0] && end <= interval[1]) {
                list.add(interval);
                add = true;
            } else if (begin <= interval[0]) {
                end = interval[1];
            } else {
                begin = interval[0];
            }
        }
        if (!add) {
            list.add(new int[]{begin, end});
        }
        return list.toArray(new int[list.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}