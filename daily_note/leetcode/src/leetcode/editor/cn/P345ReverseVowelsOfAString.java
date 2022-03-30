package leetcode.editor.cn;

//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 191 👎 0

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P345ReverseVowelsOfAString{
    public static void main(String[] args) {
        Solution solution = new P345ReverseVowelsOfAString().new Solution();
        System.out.println(solution.reverseVowels("hello"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        Set<Character> set = Stream.of('a','e','i','o','u','A','E','I','O','U').collect(Collectors.toSet());
        char[] arr = s.toCharArray();
        char temp;
        while (left < right) {
            while (left < right && !set.contains(arr[left])) {
                left++;
            }
            while (left < right && !set.contains(arr[right])) {
                right--;
            }
            if (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}