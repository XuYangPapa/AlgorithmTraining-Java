package leetcode;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class no16and24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		no16and24 test = new no16and24();
		int[] nums = { 5, 6, 5 };
		System.out.println(test.pairSums(nums, 11));

	}

	public List<List<Integer>> pairSums(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		List<List<Integer>> ans = new ArrayList<>();
		for (int num : nums) {
			Integer count = map.get(target - num);
			if (count != null) {
				ans.add(Arrays.asList(num, target - num));
				if (count == 1)
					map.remove(target - num);
				else
					map.put(target - num, --count);
			} else
				map.put(num, map.getOrDefault(num, 0) + 1);
		}

		return ans;

	}

}
