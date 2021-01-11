package top.hengshare.interview.algorithm.tree;

import lombok.Data;

/**
 * 树节点
 *
 * @author StivenYang
 * @since 2020/12/26
 **/
@Data
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
