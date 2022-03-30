package leetcode.editor.cn;

//给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。 
//
// 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。 
//
// 
//
// 示例 1： 
//
// 
//输入：date = "2019-01-09"
//输出：9
// 
//
// 示例 2： 
//
// 
//输入：date = "2019-02-10"
//输出：41
// 
//
// 示例 3： 
//
// 
//输入：date = "2003-03-01"
//输出：60
// 
//
// 示例 4： 
//
// 
//输入：date = "2004-03-01"
//输出：61 
//
// 
//
// 提示： 
//
// 
// date.length == 10 
// date[4] == date[7] == '-'，其他的 date[i] 都是数字 
// date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日 
// 
// Related Topics 数学 字符串 
// 👍 75 👎 0

public class P1154DayOfTheYear{
    public static void main(String[] args) {
        Solution solution = new P1154DayOfTheYear().new Solution();
        System.out.println(solution.dayOfYear("2019-01-09"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dayOfYear(String date) {
        String[] arr = date.split("-");
        int[] numArr = new int[]{0,31,60,91,121,152,182,213,244,274,305,335};
        int ans = numArr[Integer.valueOf(arr[1]) - 1] + Integer.valueOf(arr[2]);
        if (Integer.valueOf(arr[1]) > 2 && !checkYear(Integer.valueOf(arr[0]))) {
            return ans - 1;
        }
        return ans;
    }

    private boolean checkYear(int year) {
        if (year % 4 != 0) {
            return false;
        }
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}