package top.hengshare.interview.algorithm.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * 后序遍历
 *
 * @author yjh
 * @date 2020/12/29 12:46 上午
 **/
@Slf4j
public class AfterTrace {

	public void afterTrace(TreeNode node) {
		if (node == null) {
			return;
		}

		afterTrace(node.left);
		afterTrace(node.right);
		log.info("{}", node);
	}
}
