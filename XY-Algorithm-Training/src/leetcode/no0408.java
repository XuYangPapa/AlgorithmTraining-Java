package leetcode;

public class no0408 {

	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root==null||root.val==p.val||root.val==q.val)
    		return root;
    	TreeNode left=lowestCommonAncestor(root.left, p,q);
    	TreeNode right=lowestCommonAncestor(root.right, p,q);
    	if(left!=null&&right!=null)
    		return root;
    	else if(left!=null&&right==null)
    		return left;
    	else 
    		return right;    				
    }
 
	

}
