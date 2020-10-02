package leetcode;

public class no968 {

	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int res;
	public int minCameraCover(TreeNode root) {
		if(dfs(root)==1)res+=1;
		return res;

    }
	
	public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = dfs(root.left);
        int right= dfs(root.right);
        if(left==1||right==1){
            res++;
            return 2;
        }else if(left==2||right==2){
            return 0;
        }else{
            return 1;
        }
    }
}
