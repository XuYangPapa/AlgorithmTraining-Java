package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class no106 {

	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array= {1,2,3};
		System.out.print(Arrays.toString(array));
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length==0)return null;
		TreeNode root=new TreeNode(postorder[postorder.length-1]);
		String instr=String.valueOf(inorder);
		String poststr=String.valueOf(postorder);
		constructor(root,instr,poststr);
		return root;
    }
	
	public void constructor(TreeNode root,String instr,String poststr) {
		int inIndex=instr.indexOf((char)root.val);
		String leftin=instr.substring(0,inIndex);
		String rightin=instr.substring(inIndex+1,instr.length());
		String leftpost=poststr.substring(0,inIndex);
		String rightpost=poststr.substring(inIndex+1,instr.length());
		if(leftin.length()!=0) {
			TreeNode left=new TreeNode(Integer.valueOf(leftpost.charAt(leftpost.length()-1)));
			root.left=left;
			constructor(left,leftin,leftpost);
		}
		if(rightin.length()!=0) {
			TreeNode right=new TreeNode(Integer.valueOf(rightpost.charAt(rightpost.length()-1)));
			root.right=right;
			constructor(right,rightin,rightpost);
		}
		
	}

}
