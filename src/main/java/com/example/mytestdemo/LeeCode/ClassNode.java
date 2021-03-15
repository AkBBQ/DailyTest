package com.example.mytestdemo.LeeCode;

/**
 * 根据前序遍历、中序遍历的结果
 * 重构出二叉树
 */


public class ClassNode {
    //{4,7,2,1,5,3,8,6}中序遍历
    //{1,2,4,7,3,5,6,8}前序遍历
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                //算出左子树和又子树

                //中序左子树
                int inLeft[] = subArr(in, 0, i);
                //中序右子树
                int inRight[] = subArr(in, i, in.length);

                //前序左子树
                int preLeft[] = subArr(pre, 1, i);

                //前序右子树
                int preRight[] = subArr(pre, i + 1, pre.length);

                root.left = reConstructBinaryTree(preLeft, inLeft);
                root.right = reConstructBinaryTree(preRight, inRight);

            }
        }


        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public  int[] subArr(int[] arr,int begin,int end){
        int leftOrRight[] = new int[end - begin];
        for (int i = 0, j = begin; j < end; j++, i++) {
            leftOrRight[i] = arr[j];
        }
        return leftOrRight;
    }
}


