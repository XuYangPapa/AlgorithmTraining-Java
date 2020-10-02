package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class no546 {

	public static void main(String[] args) {
		no546 test=new no546();
		int[] boxes= {1,3,2,2,2,3,4,3,1};
		System.out.println(test.removeBoxes(boxes));
	}
	HashMap<LinkedList<Integer>,Integer> dpMap;
	int maxValue;
	public int removeBoxes(int[] boxes) {
		dpMap=new HashMap<LinkedList<Integer>,Integer>();
		maxValue=0;
		LinkedList<Integer> inputList=new LinkedList<Integer>();
		for(int i:boxes)
			inputList.add(i);
		search(inputList);
		return maxValue;
    }
	public int search(LinkedList<Integer> startList) {
		Integer value=dpMap.get(startList);
		if(value!=null) {
			return value;
		}else {
			if(startList.size()==0) {
				return 0;
			}else {
				int tempMaxValue=0;
				LinkedList<Integer> tempMaxList = null;
				for(int i=0;i<startList.size();i++) {
					LinkedList<Integer> tempList=listClone(startList);
					int tempValue=pickElement(tempList,i);
					tempValue+=search(tempList);
//					String s="";
//					for(Integer x:tempList)
//						s=s+x.toString()+" ";
//					System.out.println(s+":  "+tempValue);
					if(tempValue>=tempMaxValue) {
						tempMaxValue=tempValue;
						tempMaxList=tempList;
					}
				}		
				dpMap.put(startList,tempMaxValue);
//				String s="";
//				for(Integer x:startList)
//					s=s+x.toString()+" ";
//				System.out.println(s+":  "+tempMaxValue);
				if(tempMaxValue>maxValue)maxValue=tempMaxValue;
				return tempMaxValue;
			}
		}
	     
		
	}
	public int pickElement(LinkedList<Integer> startList,int startIndex) {
		int endIndex=startIndex;
		while(startList.get(startIndex).equals(startList.get(endIndex))) {
			endIndex++;
			if(endIndex>=startList.size())break;
		}
		endIndex--;
		int tempvalue=(endIndex-startIndex)+1;
		tempvalue*=tempvalue;
		int tempIndex=startIndex;
		ListIterator<Integer> it = startList.listIterator(startIndex);
		while(it.hasNext()) {
			Integer i=it.next();
			it.remove();
			tempIndex++;
			if(tempIndex>endIndex)break;
		}
		return tempvalue;	
		
	}
	public LinkedList<Integer> listClone(LinkedList<Integer> oldList) {
		LinkedList<Integer> newList=new LinkedList<Integer>();
		for(int i=0;i<oldList.size();i++) {
			int x=oldList.get(i).intValue();
			Integer it=new Integer(x);
			newList.add(it);
		}			
		return newList;
	}
	

}
