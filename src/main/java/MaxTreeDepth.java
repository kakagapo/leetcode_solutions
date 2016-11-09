
/**
 * Given a binary tree, find its maximum depth. The maximum depth is the number 
 * of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaxTreeDepth {
	
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
	}
	
	
	
	public int maxDepth(TreeNode root) {
		if(root != null)
			return 1+maxDepth(root, 0);
		else
			return 0;
    }
	
	private int maxDepth(TreeNode node, int depth){
		int leftDepth = depth, rightDepth = depth;
		if(node.left != null){
			leftDepth = maxDepth(node.left, 1 + depth);
		}
		if(node.right != null){
			rightDepth = maxDepth(node.right, 1 + depth);
		}
		return Math.max(leftDepth, rightDepth);
	}
	
	public static void main(String[] args) {
		
	}

}
