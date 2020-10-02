package Training;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class no20200831 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] ansArray=new int[m];
		int[] girlArray=new int[n];
		for(int i=0;i<n;i++)
			girlArray[i]=sc.nextInt();
		HashSet<Integer> girlSet=new HashSet<Integer>();
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();	
		for(int i=girlArray.length-1;i>=0;i--) {
			girlSet.add(girlArray[i]);
			map.put(i+1, girlSet.size());
		}	
		int j=0;
		while(j<m) {
			int x=sc.nextInt();
			ansArray[j++]=map.get(x);
		}
		for(int ans:ansArray) {
			System.out.println(ans);
		}
		sc.close();
	}
	
}
