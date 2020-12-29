package top.hengshare.interview.algorithm.tree;

/**
 * 中序遍历
 *
 * @author yjh
 * @date 2020/12/29 12:36 上午
 **/
public class MidTrace {

    public void midTrace(TreeNode node) {
        if (node == null) {
            return;
        }

        midTrace(node.left);
        System.out.println(node);
        midTrace(node.right);
    }
}
