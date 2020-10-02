package Training;

import java.util.Scanner;

public class no20200817 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int x=in.nextInt();
		char[] array=new char[x];
		int count=0;
		int step=0;
		while(in.hasNext()) {
			int i=in.nextInt();
			if(i<x)array[i]='x';
			else if(i==x)step=1;
			count++;
			if(count>=n)break;
		}
		in.close();
		for(int i=0;i<array.length;i++) {
			if('x'!=array[i])step++;
		}
		System.out.println(step);
	}

}
