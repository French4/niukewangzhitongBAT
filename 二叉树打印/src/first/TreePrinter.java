package first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



/*
 * ���������������ÿһ��ֿ���ӡ��
 * ��һ�ö������������һ���㷨�����ղ�δ�ӡ��ö�������
 *�����������ĸ����root���뷵�ش�ӡ������������ÿһ��һ��������д��棬���������˳���ղ����������£�
 *��ÿһ���������Ԫ�ذ��մ����������С���֤�����С�ڵ���500��
 *
 * last����ǰ���ڴ�ӡ�ĵ�ǰ�е����ҽڵ�
 * nlast:��һ�е����ҽڵ㡣
 * ��ʼ:last��Ϊ�ڵ�1,���ڵ�1���������,�Ӷ����е����ڵ�1���Ҵ�ӡ��
 * ����ڵ�2ʱ��,��nlast���ڽڵ�2
 * ����ڵ�3ʱ��,��nlast���ڽڵ�3,��ʱ���ֵ����Ľڵ�1����last���Ի��С���last = nlast��
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