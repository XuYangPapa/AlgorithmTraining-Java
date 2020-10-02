package leetcode;

import java.util.LinkedList;
import java.util.List;

public class no78 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res=new LinkedList<>();
		LinkedList<Integer> empty=new LinkedList<Integer>();
		if(nums.length==0)return res;
		else{
			LinkedList<Integer> first=new LinkedList<Integer>();
			first.add(nums[0]);
			res.add(first);	
			for(int i=1;i<nums.length;i++) {
				List<List<Integer>> tempres=new LinkedList<>();
				for(List<Integer> subset:res) {
					LinkedList<Integer> newlist=listclone(subset);
					newlist.add(nums[i]);
					tempres.add(newlist);
				}
				res.addAll(tempres);
				LinkedList<Integer> self=new LinkedList<Integer>();
				self.add(nums[i]);
				res.add(self);	
			}
			res.add(empty);
		}		
		return res;
    }
	private LinkedList<Integer> listclone(List<Integer> subset){
		LinkedList<Integer> newlist=new LinkedList<Integer>();
		for(Integer i:subset)
			newlist.add(i);
		return newlist;
	}

}
