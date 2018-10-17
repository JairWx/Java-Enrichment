package structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeTraversal {
	LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
	
	public List<Integer> preorderTraversal(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		if(root == null){
			return list;
		}
		stack.push(root);
		TreeNode node = null;
		while ( !stack.isEmpty()) {
			node = stack.pop();
			if(node != null){
				list.add(node.val);
				stack.push(node.right);
				stack.push(node.left);
			}
		}
		return list;
		
	}
}
