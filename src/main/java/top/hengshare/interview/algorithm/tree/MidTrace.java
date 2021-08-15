package top.hengshare.interview.algorithm.tree;

import lombok.extern.slf4j.Slf4j;

/**
 * 中序遍历
 *
 * @author yjh
 * @date 2020/12/29 12:36 上午
 **/
@Slf4j
public class MidTrace {

    public void midTrace(TreeNode node) {
        if (node == null) {
            return;
        }

        midTrace(node.left);
        log.info("{}", node);
        midTrace(node.right);
    }
}
