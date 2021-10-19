package top.hengshare.interview.algorithm.interview;

import top.hengshare.interview.algorithm.tree.TreeNode;

import java.util.*;

/**
 * 层序遍历，并打印每层的节点数量
 *
 * @author yjh
 * @since 2021/1/10 6:49 下午
 **/
public class LevelTraceWithNodeSum {

	public Map<Integer, Integer> getLevelTraceWitchNodeSum(TreeNode node) throws Exception {
		if (node == null) {
			throw new Exception("node can not be null");
		}
		Map<Integer, List<TreeNode>> allNodes = new HashMap<>(16);
		Queue<TreeNode> nodeQueue = new ArrayDeque<>();
		nodeQueue.add(node);
		int level = 1;
		while (!nodeQueue.isEmpty()) {
			int curLevelSize = nodeQueue.size();
			List<TreeNode> curLevelNodes = new ArrayList<>();
			for (int i = 0; i < curLevelSize; i++) {
				TreeNode curLevelNode = nodeQueue.poll();
				if (curLevelNode == null) {
					continue;
				}
				curLevelNodes.add(curLevelNode);

				if (curLevelNode.getLeft() != null) {
					nodeQueue.offer(curLevelNode.getLeft());
				}
				if (curLevelNode.getRight() != null) {
					nodeQueue.offer(curLevelNode.getRight());
				}
			}
			allNodes.put(level++, curLevelNodes);
		}

		Map<Integer, Integer> resultMap = new HashMap<>(16);
		for (Map.Entry<Integer, List<TreeNode>> levelAllNode : allNodes.entrySet()) {
			resultMap.put(levelAllNode.getKey(), levelAllNode.getValue().size());
		}

		return resultMap;
	}
}
