package leetcode;

public class no404 {

	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int sumOfLeftLeaves(TreeNode root) {
		if(root==null)
			return 0;
		int res=0;
		if(root.left!=null&&root.left.left==null&root.left.right==null) {
			res+=root.left.val;
			return res+sumOfLeftLeaves(root.right);
		}else {
			return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
		}
    }
}
