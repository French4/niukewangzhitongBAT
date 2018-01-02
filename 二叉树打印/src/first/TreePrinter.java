package first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



/*
 * 二叉树按层遍历，每一层分开打印。
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 *给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，
 *且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 *
 * last：当前正在打印的当前行的最右节点
 * nlast:下一行的最右节点。
 * 开始:last记为节点1,将节点1放入队列中,从队列中弹出节点1并且打印。
 * 放入节点2时候,让nlast等于节点2
 * 放入节点3时候,让nlast等于节点3,此时发现弹出的节点1等于last所以换行。让last = nlast。
 * */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class TreePrinter {
    public int[][] printTree(TreeNode root) {
       ArrayList<ArrayList<TreeNode>> result = new ArrayList<>();
       ArrayList<TreeNode> line = new ArrayList<>();
       Queue<TreeNode> queue = new LinkedList<>();
       
       queue.add(root);
       TreeNode temp = null;
       TreeNode last = root;
       TreeNode nlast = null;
       
       while(queue.size() != 0) {
    	   temp = queue.poll();
    	   line.add(temp);
    	   
    	   if(temp.left != null) {
    		   queue.add(temp.left);
    		   nlast = temp.left;
    	   }
    	   
    	   if(temp.right != null) {
    		   queue.add(temp.right);
    		   nlast = temp.right;
    	   }
    	   
    	   if(last == temp) {
    		   last = nlast;
    		   result.add(line);
    		   line = new ArrayList<>();
    	   }
       }
       
       int[][] result2 = new int[result.size()][];
       for(int i = 0; i < result.size(); i++) {
    	   result2[i] = new int[result.get(i).size()];
    	   for(int j = 0; j < result2[i].length; j++) {
    		   result2[i][j] = result.get(i).get(j).val;
    	   }
       }
       return result2;
    }
}