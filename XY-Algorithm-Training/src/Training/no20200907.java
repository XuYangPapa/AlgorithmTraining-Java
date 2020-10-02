package Training;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class no20200907 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] wallArray=new int[n];
		for(int i=0;i<n;i++)
			wallArray[i]=sc.nextInt();
		sc.close();
		if(n<k) {
			System.out.println("NO");
		}else {
			HashMap<Integer,LinkedList<Integer>> resMap=new HashMap<Integer,LinkedList<Integer>>();
			boolean sign=true;
			for(int i=0;i<n;i++) {
				if(resMap.keySet().contains(wallArray[i])) {
					LinkedList<Integer> ll=resMap.get(wallArray[i]);
					if(ll.size()>=k) {
						sign=false;
						break;
					}else {
						ll.add(i);
						resMap.put(wallArray[i],ll);
					}
				}else {
					LinkedList<Integer> ll=new LinkedList<Integer>();
					ll.add(i);
					resMap.put(wallArray[i], ll);
				}
			}
			if(!sign) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
				int[] resArray=new int[n];
				int curUsed=1;
				for(Integer i:resMap.keySet()) {
					LinkedList<Integer> ll=resMap.get(i);
					for(Integer index:ll) {
						resArray[index]=curUsed++;
						if(curUsed>k)curUsed=1;
					}
				}
				for(int res:resArray)
					System.out.print(res+" ");
			}
		}
	}
	

}
