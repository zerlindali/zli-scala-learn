package day03.nowcoder;

/**
 * @author ZerlindaLi create at 2019/9/17 15:23
 * @version 1.0.0
 * @description RebuildBinaryTree
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 *
 * 中序遍历：左子树---> 根结点 ---> 右子树
 *
 * 后序遍历：左子树 ---> 右子树 ---> 根结点
 */
public class RebuildBinaryTree {

    /**
     *
     * @param pre 前序
     * @param in 中序
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for(int i = 0; i<in.length; i++) {
            if(pre[0] == in[i]){
                // 左子树，注意 copyOfRange 函数，左闭右开
                int [] left_1 = new int[i];
                for(int j = 0; j < i; j++){
                    left_1[j] = pre[j+1];
                }
                int [] left_2 = new int[i];
                for(int k = 0; k < i; k++){
                    left_2[k] = in[k];
                }
                root.left = reConstructBinaryTree(left_1,left_2);

                // 右子树，注意 copyOfRange 函数，左闭右开
                int [] right_1 = new int[pre.length - i - 1];
                for(int m = 0; m < pre.length - i - 1 ; m++) {
                    right_1[m] = pre[m+i+1];
                }
                int [] right_2 = new int[in.length - i - 1];
                for(int n = 0; n < in.length - i - 1; n++){
                    right_2[n] = in[n + i + 1];
                }
                root.right = reConstructBinaryTree(right_1, right_2);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int [] pre = {1,2,3,4};
        int [] in = {4,3,2,1};
        TreeNode treeNode = new RebuildBinaryTree().reConstructBinaryTree(pre,in);
        treeNode.preOrderTraverse1(treeNode);
        System.out.println();
        treeNode.inOrderTraverse1(treeNode);
    }
}



