package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class no1177 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		no1177 test=new no1177();
		String s="abcda";
		int[][] queries= {{3,3,0}};
		System.out.println(test.canMakePaliQueries(s, queries));
	}

	public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		List<Boolean> res=new LinkedList<Boolean>();
		int[][] fullres=new int[s.length()][s.length()];
		for(int i=0;i<s.length();i++) {
			HashSet<Character> charset=new HashSet<Character>();
			for(int j=i;j<s.length();j++) {
				if(charset.contains(s.charAt(j))) {
					charset.remove(s.charAt(j));
				}else {
					charset.add(s.charAt(j));
				}
				fullres[i][j]=charset.size()/2;
			}
		}
		
		
		for(int i=0;i<queries.length;i++) {
			int left=queries[i][0];
			int right=queries[i][1];
			int k=queries[i][2];
			boolean r=fullres[left][right]<=k;
			res.add(r);
		}
		
		return res;
    }
	
}
