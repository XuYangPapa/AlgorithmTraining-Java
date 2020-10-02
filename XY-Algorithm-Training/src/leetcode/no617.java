package leetcode;

public class no617 {

	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(null==t1&&null==t2)return null;
		else if(null==t1&&null!=t2) {			
			return t2;
		}else if(null!=t1&&null==t2) {
			
		}else {
			t1.val+=t2.val;
			t1.left=mergeTrees(t1.left,t2.left);
			t1.right=mergeTrees(t1.right,t2.right);
		}
		return t1;
    }

}
