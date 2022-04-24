package leetcode.editor.cn;

//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,104] 
// -231 <= Node.val <= 231 - 1 
// 
//
// 
//
// 注意：本题与主站 513 题相同： https://leetcode-cn.com/problems/find-bottom-left-tree-valu
//e/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 20 👎 0

import java.util.LinkedList;
import java.util.Queue;

public class POffer045{
    public static void main(String[] args) {
        Solution solution = new POffer045().new Solution();
        
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
    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int temp = 0;
        int nextTemp = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            temp--;
            if (node.left != null) {
                queue.offer(node.left);
                if (nextTemp == 0) {
                    ans = node.left.val;
                }
                nextTemp++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                if (nextTemp == 0) {
                    ans = node.right.val;
                }
                nextTemp++;
            }
            if (temp < 0) {
                temp = nextTemp;
                nextTemp = 0;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}