package top.hengshare.interview.algorithm.tree;

/**
 * 先序遍历
 *
 * @author yjh
 * @date 2020/12/29 12:28 上午
 **/
public class BeforeTrace {

    public void beforeTrace(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node);

        if (node.left != null) {
            beforeTrace(node.left);
        }

        if (node.right != null) {
            beforeTrace(node.right);
        }
    }
}
