package top.hengshare.interview.algorithm.tree;

import org.junit.Assert;
import org.junit.Test;

public class IsBalancedTest {

    @Test
    public void testIsBalanced() {
        IsBalanced isBalanced = new IsBalanced();

        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(3, left, right);
        boolean balanced = isBalanced.isBalanced(root);
        Assert.assertTrue(balanced);

        TreeNode two = new TreeNode(2, null, null);
        right.right = two;
        Assert.assertTrue(isBalanced.isBalanced(root));

        two.left = new TreeNode(4, null, null);
        Assert.assertFalse(isBalanced.isBalanced(root));
    }


}