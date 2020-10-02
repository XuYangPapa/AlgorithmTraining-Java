package leetcode;

import java.util.HashMap;

public class no560 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		no560 test=new no560();
		int[]nums= {0,0,0,0,0,0,0,0,0,0};
		System.out.println(test.subarraySum(nums, 0));
	}
	public int subarraySum(int[] nums, int k) {
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		map.put(0, 1);
		int count=0;
		int sum=0;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			int diff=sum-k;
			if(map.containsKey(diff)) {
				count+=map.get(diff);
			}
			if(map.containsKey(sum)) {
				int value=map.get(sum)+1;
				map.put(sum, value);
				
			}else {
				map.put(sum, 1);
			}
		}
		return count;
    }

}
