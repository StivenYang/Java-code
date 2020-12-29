package top.hengshare.interview.algorithm.tree;

import org.junit.Assert;
import org.junit.Test;

public class MaxDepthTest {

    @Test
    public void maxDepth() {
        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(3, left, right);
        TreeNode two = new TreeNode(2, null, null);
        two.left = new TreeNode(4, null, null);
        right.right = two;

        MaxDepth maxDepth = new MaxDepth();
        int i = maxDepth.maxDepth(root);
        Assert.assertEquals(i, 4);
    }
}