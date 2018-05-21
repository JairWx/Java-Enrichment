package structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历，中序遍历，后序遍历，主要看根结点在什么位置，左边永远要比右边先输出
 * @author jair
 *
 */
public class TreeTraversalRecursion {
	/**
	 * 前序遍历
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> resultList = new ArrayList<Integer> ();
        if(root == null) {
            return resultList;
        }
        resultList.add(root.val);//输出根结点
        if(root.left != null) {
            resultList.addAll(preorderTraversal(root.left));
        }
        if(root.right != null) {
            resultList.addAll(preorderTraversal(root.right));
        }
        return resultList;
	}
	
	/**
	 * 中序遍历
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> resultList = new ArrayList<Integer> ();
        if(root == null) {
            return resultList;
        }
        
        if(root.left != null) {
            resultList.addAll(preorderTraversal(root.left));
        }
        resultList.add(root.val);//输出根结点
        if(root.right != null) {
            resultList.addAll(preorderTraversal(root.right));
        }
        return resultList;
	}
	/**
	 * 后序遍历
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> resultList = new ArrayList<Integer> ();
        if(root == null) {
            return resultList;
        }
        if(root.left != null) {
            resultList.addAll(preorderTraversal(root.left));
        }
        if(root.right != null) {
            resultList.addAll(preorderTraversal(root.right));
        }
        resultList.add(root.val);//输出根结点
        return resultList;
	}
}
