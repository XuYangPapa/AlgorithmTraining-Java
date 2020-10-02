package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class no416 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		no416 test=new no416();
		int[]nums= {1,2,3,4,5,6,7};
		System.out.println(test.canPartition(nums));
	}
	
	public boolean canPartition(int[] nums) {
		ArrayList<Integer> list=new ArrayList<Integer>(nums.length);
		for(int i:nums)list.add(i);
		Collections.sort(list);
		int start=0,end=list.size()-1;
		int half=(start+end)/2;
		HashSet<Integer> used=new HashSet<Integer>();
		while(true) {	
			int left=sum(list,start,half);
			int right=sum(list,half+1,end);
			System.out.println(half);
			if(left>right) {
				half=(start+half)/2;
				if(used.contains(half))break;
				else used.add(half);
			}else if(left<right) {
				half=(half+end)/2;
				if(used.contains(half))break;
				else used.add(half);
			}else {
				return true;
			}
		}
		return false;
    }
	public int sum(ArrayList<Integer> list,int start,int end) {
		int value=0;
		for(int i=start;i<=end;i++) {
			value+=list.get(i);
		}
		return value;
	}

}
