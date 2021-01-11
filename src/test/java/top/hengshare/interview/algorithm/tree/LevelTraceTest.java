package top.hengshare.interview.algorithm.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LevelTraceTest {

    private TreeNode root;

    @Before
    public void buildTree(){
        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(2, null, null);
        root = new TreeNode(3, left, right);
        TreeNode two = new TreeNode(2, null, null);
        two.left = new TreeNode(4, null, null);
        right.right = two;
    }

    @Test
    public void levelTrace() {
        List<List<Integer>> lists = new LevelTrace().levelTrace(root);
        System.out.println(lists.toString());
    }

    @Test
    public void levelTraceWithMn() {
        TreeNode treeNode = new LevelTrace().levelTraceWithMn(root, 3, 1);
        assertEquals(treeNode.val, 2);
    }
}