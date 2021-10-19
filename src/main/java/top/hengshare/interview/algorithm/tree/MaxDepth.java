package top.hengshare.interview.algorithm.tree;

/**
 * 求二叉树的最大深度
 *
 * @author yjh
 * @date 2020/12/28 8:19 下午
 **/
public class MaxDepth {

	public int maxDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftDepth = maxDepth(node.left);
		int rightDepth = maxDepth(node.right);

		return Math.max(leftDepth, rightDepth) + 1;
	}
}
