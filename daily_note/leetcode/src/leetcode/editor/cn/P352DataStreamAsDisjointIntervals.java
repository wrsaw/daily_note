package leetcode.editor.cn;

//给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。 
//
// 实现 SummaryRanges 类： 
//
// 
// 
// 
// SummaryRanges() 使用一个空数据流初始化对象。 
// void addNum(int val) 向数据流中加入整数 val 。 
// int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum"
//, "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
//[[], [1], [], [3], [], [7], [], [2], [], [6], []]
//输出：
//[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]],
// null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
//
//解释：
//SummaryRanges summaryRanges = new SummaryRanges();
//summaryRanges.addNum(1);      // arr = [1]
//summaryRanges.getIntervals(); // 返回 [[1, 1]]
//summaryRanges.addNum(3);      // arr = [1, 3]
//summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
//summaryRanges.addNum(7);      // arr = [1, 3, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
//summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
//summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= val <= 104 
// 最多调用 addNum 和 getIntervals 方法 3 * 104 次 
// 
// 
// 
//
// 
//
// 进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办? 
// Related Topics 设计 二分查找 有序集合 
// 👍 97 👎 0

import java.util.Map;
import java.util.TreeMap;

public class P352DataStreamAsDisjointIntervals{
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class SummaryRanges {

        private TreeMap<Integer, Integer> treeMap;

        public SummaryRanges() {
            treeMap = new TreeMap();
        }

        public void addNum(int val) {
            Map.Entry<Integer, Integer> f = treeMap.floorEntry(val);
            Map.Entry<Integer, Integer> c = treeMap.ceilingEntry(val + 1);


            if (f != null && f.getValue() >= val) {
                //val在一个已有的区间内

            } else if (f != null && f.getValue() == val - 1 && c != null && c.getKey() == val + 1) {
                //val能把两个区间连起来
                treeMap.put(f.getKey(), c.getValue());
                treeMap.remove(val + 1);
            } else if (f != null && f.getValue() == val - 1) {
                //加到左区间的右边
                treeMap.put(f.getKey(), val);
            } else if (c != null && c.getKey() == val + 1) {
                //加到右区间的左边
                treeMap.put(val, c.getValue());
                treeMap.remove(val + 1);
            } else {
                //独立一个
                treeMap.put(val, val);
            }
        }

        public int[][] getIntervals() {
            int[][] ans = new int[treeMap.size()][2];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                ans[i++] = new int[]{entry.getKey(), entry.getValue()};
            }
            return ans;
        }
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
//leetcode submit region end(Prohibit modification and deletion)

}