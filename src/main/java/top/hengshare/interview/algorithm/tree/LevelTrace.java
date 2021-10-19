package top.hengshare.interview.algorithm.tree;


import java.util.*;

/**
 * 层序遍历
 *
 * @author yjh
 * @date 2020/12/29 12:58 上午
 **/
public class LevelTrace {

	/**
	 * 层序遍历
	 *
	 * @param node 需要遍历的根节点
	 * @return 遍历之后的树
	 */
	public List<List<Integer>> levelTrace(TreeNode node) {
		if (node == null) {
			return null;
		}
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			int count = queue.size();
			List<Integer> list = new ArrayList<>();
			while (count > 0) {
				TreeNode poll = queue.poll();
				if (poll == null) {
					continue;
				}
				list.add(poll.val);
				if (poll.left != null) {
					queue.add(poll.left);
				}
				if (poll.right != null) {
					queue.add(poll.right);
				}
				count--;
			}
			res.add(list);
		}
		return res;
	}

	/**
	 * 层序遍历，获取树中的第m行，第n个元素
	 *
	 * @param node 要遍历的根节点
	 */
	public TreeNode levelTraceWithMn(TreeNode node, Integer m, Integer n) {
		if (node == null || m <= 0 || n <= 0) {
			return null;
		}
		Map<Integer, List<TreeNode>> allNodes = new HashMap<>(64);
		Queue<TreeNode> nodeQueue = new ArrayDeque<>();
		nodeQueue.offer(node);
		int level = 1;

		while (!nodeQueue.isEmpty()) {
			List<TreeNode> curLevelNodes = new ArrayList<>();
			int size = nodeQueue.size();
			for (int i = 0; i < size; i++) {
				TreeNode treeNode = nodeQueue.poll();
				if (treeNode == null) {
					continue;
				}
				curLevelNodes.add(treeNode);
				if (treeNode.getLeft() != null) {
					nodeQueue.offer(treeNode.getLeft());
				}
				if (treeNode.getRight() != null) {
					nodeQueue.offer(treeNode.getRight());
				}
			}
			allNodes.put(level++, curLevelNodes);
		}

		List<TreeNode> mLevelNodeList = allNodes.get(m);
		if (mLevelNodeList == null || mLevelNodeList.size() < n) {
			return null;
		}
		return mLevelNodeList.get(n - 1);
	}
}
