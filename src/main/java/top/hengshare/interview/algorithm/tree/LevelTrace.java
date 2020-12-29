package top.hengshare.interview.algorithm.tree;

import java.util.*;

/**
 * 层序遍历
 *
 * @author yjh
 * @date 2020/12/29 12:58 上午
 **/
public class LevelTrace {

    /**
     * 层序遍历
     *
     * @param node 需要遍历的根节点
     * @return 遍历之后的树
     */
    public List<List<Integer>> levelTrace(TreeNode node) {
        if (node == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 层序遍历，获取树中的第m行，第n个元素
     *
     * @param node 要遍历的根节点
     */
    public TreeNode levelTraceWithMn(TreeNode node, Integer m, Integer n) {
        if (node == null) {
            return null;
        }
        // 使用一个map保存各个层级的树节点
        Map<Integer, List<TreeNode>> allNodes = new HashMap<>();
        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(node);
        allNodes.put(1, rootList);
        //获取全部的迭代器，一层一层的迭代，直到迭代器里面没有值
        for (Map.Entry<Integer, List<TreeNode>> curLevelNodes : allNodes.entrySet()) {
            //获取当前层所有节点，key为层数，list为当前层全部节点信息
            List<TreeNode> curList = curLevelNodes.getValue();
            System.out.println(curList);
            if (curList.size() == 0) {
                break;
            }
            Integer curKey = curLevelNodes.getKey();
            Integer nextKey = curKey + 1;
            Map<Integer, List<TreeNode>> nextMap = new HashMap<>();
            //定义一个list，保存所有的下一层节点
            List<TreeNode> nextNodes = new ArrayList<>();
            //遍历当前层，获取所有下层节点信息
            for (TreeNode treeNode : curList) {
                if (treeNode.left != null) {
                    nextNodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextNodes.add(treeNode.right);
                }
            }
            allNodes.put(nextKey, nextNodes);
        }
        List<TreeNode> treeNodes = allNodes.get(m);
        return treeNodes.get(n);
    }
}
