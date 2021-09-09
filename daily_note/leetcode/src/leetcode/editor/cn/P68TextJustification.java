package leetcode.editor.cn;

//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 说明: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 示例: 
//
// 输入:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 输入:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 输入:
//words = ["Science","is","what","we","understand","well","enough","to","explain
//",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
// Related Topics 字符串 模拟 
// 👍 181 👎 0

import java.util.ArrayList;
import java.util.List;

public class P68TextJustification{
    public static void main(String[] args) {
        Solution solution = new P68TextJustification().new Solution();
        System.out.println(solution.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ans = new ArrayList<>();
            if (words.length == 1) {
                String temp = words[0] + getNBlack(maxWidth - words[0].length());
                ans.add(temp);
                return ans;
            }
            List<String> tempList = new ArrayList<>();
            tempList.add(words[0]);
            int tempLength = words[0].length();
            for (int i = 1; i < words.length; i++) {
                while (i < words.length && tempLength + words[i].length() + 1 <= maxWidth) {
                    tempList.add(words[i]);
                    tempLength = tempLength + 1 + words[i].length();
                    i++;
                }
                handleOneLine(ans, tempList, i == words.length, maxWidth);
                if (i < words.length) {
                    tempList = new ArrayList<>();
                    tempList.add(words[i]);
                    tempLength = words[i].length();
                    if (i == words.length - 1) {
                        handleOneLine(ans, tempList, i == words.length - 1, maxWidth);
                    }
                }
            }
            return ans;
        }

        private void handleOneLine(List<String> ans, List<String> tempList, boolean isLast, int maxWidth) {
            StringBuilder builder = new StringBuilder();
            if (isLast) {
                for (int i = 0; i < tempList.size(); i++) {
                    if (i > 0) {
                        builder.append(" ");
                    }
                    builder.append(tempList.get(i));
                }
                if (builder.length() < maxWidth) {
                    builder.append(getNBlack(maxWidth - builder.length()));
                }
            } else {
                int num = tempList.size();
                int total = 0;
                for (String temp : tempList) {
                    total += temp.length();
                }
                List<String> black = new ArrayList<>();
                if (num == 1 || num == 2) {
                    black.add(getNBlack(maxWidth - total));
                } else {
                    int blackNum = num - 1;
                    int bigNum = (maxWidth - total) % blackNum;
                    int bNum = (maxWidth - total) / blackNum;
                    if (bigNum > 0) {
                        String big = getNBlack(bNum + 1);
                        for (int i = 0; i < bigNum; i++) {
                            black.add(big);
                        }
                    }
                    String small = getNBlack(bNum);
                    for (int i = 0; i < blackNum - bigNum; i++) {
                        black.add(small);
                    }
                }
                for (int i = 0; i < tempList.size(); i++) {
                    builder.append(tempList.get(i));
                    if (black.size() > i) {
                        builder.append(black.get(i));
                    }
                }
            }
            ans.add(builder.toString());
        }

        private String getNBlack(int n) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                builder.append(" ");
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}