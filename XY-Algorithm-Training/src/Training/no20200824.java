package Training;

import java.util.Scanner;

public class no20200824 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		no20200824 test=new no20200824();
		int t=sc.nextInt();//ÓÃÀıÊı
		int[] resArray=new int[t];
		int x=0;
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int k=sc.nextInt();
			int[] inputarray=new int[k];
			for(int i=0;i<k;i++) {
				inputarray[i]=sc.nextInt();
			}		
			resArray[x]=test.minTime(n,k,inputarray);
			x++;
			if(x==t)break;
		}
		for(int res:resArray)
			System.out.println(res);

	}
    public int minTime(int n, int k, int[] x){
        if (k == 1){
            return Math.max(x[0],n-x[0]+1);
        }

        int temp = Math.max(x[0],n-x[k-1]+1);

        for (int i = 1; i < k; i++){
            int hose = x[i];
            int preHose = x[i-1];
            int distance =  hose - preHose + 1;
            int time = (distance + 1) / 2;
            temp = Math.max(temp,time);
        }

        return temp;
    }

}
