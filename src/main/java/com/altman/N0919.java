package com.altman;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ji.yuhong
 * @date 2024/7/23 20:26
 */
public class N0919 {

    public static class CBTInserter {

        List<TreeNode> list = new ArrayList<>();
        int index = 0;

        public CBTInserter(TreeNode root) {
            list.add(root);
            int cur = 0;
            while (cur < list.size()) {
                TreeNode treeNode = list.get(cur);
                if (treeNode.left != null) {
                    list.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    list.add(treeNode.right);
                }
                cur++;
            }
        }

        public int insert(int val) {
            TreeNode treeNode = new TreeNode(val);
            TreeNode parent;
            while ((parent = list.get(index)).left != null && parent.right != null) {
                index++;
            }
            if (parent.left == null) {
                parent.left = treeNode;
            } else {
                parent.right = treeNode;
            }
            list.add(treeNode);
            return parent.val;
        }

        public TreeNode get_root() {
            return list.get(0);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
