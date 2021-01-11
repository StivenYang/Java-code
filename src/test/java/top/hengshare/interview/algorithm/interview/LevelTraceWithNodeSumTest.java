package top.hengshare.interview.algorithm.interview;

import org.junit.Before;
import org.junit.Test;
import top.hengshare.interview.algorithm.tree.TreeNode;

import java.util.Map;

import static org.junit.Assert.*;

public class LevelTraceWithNodeSumTest {

    private TreeNode root;

    @Before
    public void buildTree(){
        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(2, null, null);
        root = new TreeNode(3, left, right);
        TreeNode two = new TreeNode(2, null, null);
        two.setLeft(new TreeNode(4, null, null));
        right.setRight(two);
    }

    @Test
    public void getLevelTraceWitchNodeSum() throws Exception {
        LevelTraceWithNodeSum levelTraceWithNodeSum = new LevelTraceWithNodeSum();
        Map<Integer, Integer> levelTraceWitchNodeSum = levelTraceWithNodeSum.getLevelTraceWitchNodeSum(root);
        System.out.println(levelTraceWitchNodeSum);
    }
}