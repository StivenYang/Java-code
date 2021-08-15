package top.hengshare.interview.algorithm.tree;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BeforeTraceTest {

    @Test
    public void beforeTrace() {
        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(3, left, right);
        TreeNode two = new TreeNode(2, null, null);
        two.left = new TreeNode(4, null, null);
        right.right = two;

        new BeforeTrace().beforeTrace(root);
        assertTrue(true);
    }
}