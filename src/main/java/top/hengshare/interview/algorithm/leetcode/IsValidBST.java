package top.hengshare.interview.algorithm.leetcode;

/**
 * @author StevenYang
 * @description 验证一个树是否是二叉排序树
 * @date 2020/7/21
 **/
public class IsValidBST {

    public boolean isValidBST1(TreeNode root) {
        return recurse(root, null, null);
    }

    private boolean recurse(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!recurse(node.right, val, upper)) return false;
        if (!recurse(node.left, lower, val)) return false;

        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}