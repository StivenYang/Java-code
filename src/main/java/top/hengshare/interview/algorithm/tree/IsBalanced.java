package top.hengshare.interview.algorithm.tree;

/**
 * 判断一颗树是否是平衡的
 *
 * @author yjh
 * @date 2020/12/27 11:30 下午
 **/
public class IsBalanced {


    public boolean isBalanced(TreeNode root) {
        return isBalancedAction(root).isBalance;
    }

    private ReturnNode isBalancedAction(TreeNode root) {
        if (root == null) {
            return new ReturnNode(true, 0);
        }

        ReturnNode left = isBalancedAction(root.left);
        ReturnNode right = isBalancedAction(root.right);

        if (!left.isBalance || !right.isBalance) {
            return new ReturnNode(false, 0);
        }
        if (Math.abs(left.depth - right.depth) > 1) {
            return new ReturnNode(false, 0);
        }

        return new ReturnNode(true, Math.max(left.depth, right.depth) + 1);
    }

    /**
     * 返回节点定义
     */
    private static class ReturnNode {

        boolean isBalance;

        int depth;

        public ReturnNode(boolean isBalance, int depth) {
            this.isBalance = isBalance;
            this.depth = depth;
        }
    }
}
