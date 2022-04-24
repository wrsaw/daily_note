package leetcode.editor.cn;

//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 注意：本题与主站 199 题相同：https://leetcode-cn.com/problems/binary-tree-right-side-view
/// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 25 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class POffer046{
    public static void main(String[] args) {
        Solution solution = new POffer046().new Solution();
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int num = 1;
        int nextNum = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            num--;
            if (num == 0) {
                ans.add(node.val);
            }
            if (node.left != null) {
                queue.offer(node.left);
                nextNum++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextNum++;
            }
            if (num == 0) {
                num = nextNum;
                nextNum = 0;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}