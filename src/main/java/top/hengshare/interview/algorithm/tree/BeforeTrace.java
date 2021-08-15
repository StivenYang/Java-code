package top.hengshare.interview.algorithm.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * 先序遍历
 *
 * @author yjh
 * @date 2020/12/29 12:28 上午
 **/
@Slf4j
public class BeforeTrace {

    public void beforeTrace(TreeNode node) {
        if (node == null) {
            return;
        }

        log.info("{}", node);

        if (node.left != null) {
            beforeTrace(node.left);
        }

        if (node.right != null) {
            beforeTrace(node.right);
        }
    }
}
