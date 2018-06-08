package structure.tree;

import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树相关操作
 * @author jair
 *
 */
public class MainTreeNode {
	
	/**
	 * 将str转换为二叉树
	 * @param str
	 * @return
	 */
	public TreeNode stringToTreeNode(String str) {
		str = str.substring(1, str.length() -1);
		String[] strs = str.split(",");
		Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
		for(String s1 : strs) {
			queue.add(Integer.valueOf(s1));
		}
		TreeNode node = null;
		TreeNode root = new TreeNode(queue.poll());
		while(!queue.isEmpty()){
			Integer val = queue.poll();
			if(node.left == null) {
				node.left = new TreeNode(val);
			}else
			if(node.right == null) {
				node.right = new TreeNode(val);
			}else{
			
			}
			
		}
		return root;
	}
}
