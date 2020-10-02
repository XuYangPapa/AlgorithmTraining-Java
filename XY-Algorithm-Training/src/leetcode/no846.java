package leetcode;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class no846 {

	public static void main(String[] args) {
		no846 test=new no846();
		int[]hand= {1,1,2,2,3,3};
		System.out.println(test.isNStraightHand(hand, 2));
	}

	public boolean isNStraightHand(int[] hand, int W) {
		if(hand.length%W!=0)return false;
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int v:hand) list.add(v);
		Collections.sort(list);
		while(list.size()>0) {
			Iterator<Integer> iter = list.iterator();
			for(int v:list)
				System.out.print(v+" ");
			System.out.println("");
			int pre=-1;
			int temp=0;
			while(iter.hasNext()) {
				int cur=iter.next();
				if(pre==-1) {
					pre=cur;
					iter.remove();
					temp+=1;
				}else {
					if(pre==cur) {
						System.out.println(pre+" "+cur+" "+temp);
						pre=cur;
					}else if(pre+1==cur) {
						temp+=1;
						System.out.println(pre+" "+cur+" "+temp);
						pre=cur;
						iter.remove();
						pre=cur;
					}else {
						System.out.println(pre+" "+cur+" "+temp);
						return false;
					}
					
				}
				if(temp==W)break;			
			}
			if(temp!=W)return false;
		}
		if(list.size()==0)return true;
		return false;
		
    }
	
}
