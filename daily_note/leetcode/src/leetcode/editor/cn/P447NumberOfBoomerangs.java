package leetcode.editor.cn;

//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
// 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -104 <= xi, yi <= 104 
// 所有点都 互不相同 
// 
// Related Topics 数组 哈希表 数学 
// 👍 177 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P447NumberOfBoomerangs{
    public static void main(String[] args) {
        Solution solution = new P447NumberOfBoomerangs().new Solution();
        System.out.println(solution.numberOfBoomerangs(new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int temp = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                map.putIfAbsent(temp, new HashMap<>());
                map.get(temp).putIfAbsent(i, new ArrayList<>());
                map.get(temp).get(i).add(j);
                map.get(temp).putIfAbsent(j, new ArrayList<>());
                map.get(temp).get(j).add(i);
            }
        }

        int ans = 0;
        for (Map<Integer, List<Integer>> values : map.values()) {
            for (List<Integer> value : values.values()) {
                ans += value.size() > 1 ? value.size() * (value.size() - 1) : 0;
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}