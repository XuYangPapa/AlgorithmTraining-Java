package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class no56 {

	public static void main(String[] args) {
		no56 test=new no56();
		int[][] input= {{1,3},{2,6},{8,10},{15,18}};
		test.merge(input);
	}
	
	public int[][] merge(int[][] intervals) {
		if(intervals.length==1) {
			return intervals;
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

		LinkedList<String> reslist=new LinkedList<String>();
		int curlow=intervals[0][0];
		int curhigh=intervals[0][1];
		for(int i=1;i<intervals.length;i++) {
			int low=intervals[i][0];
			int high=intervals[i][1];
			if(low<=curhigh) {
				
				curhigh=Math.max(high, curhigh);
			}else {
				reslist.add(String.valueOf(curlow)+"-"+String.valueOf(curhigh));
				curlow=low;
				curhigh=high;
			}
		}
		reslist.add(String.valueOf(curlow)+"-"+String.valueOf(curhigh));
		int[][] res=new int[reslist.size()][2];
		int i=0;
		for(String s:reslist) {
			int v1=Integer.valueOf(s.split("-")[0]);
			int v2=Integer.valueOf(s.split("-")[1]);
			res[i][0]=v1;
			res[i][1]=v2;
			System.out.println(s);
			i++;
		}
		return res;
    }

}
