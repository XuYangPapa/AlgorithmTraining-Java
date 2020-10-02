package Training;

import java.util.ArrayList;
import java.util.Scanner;

public class no20200810 {

	public StringBuffer res;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()) {
			int input=in.nextInt();
			no20200810 m=new no20200810();
			m.processor24(input);
			
		}
	}

	public void processor24(int input) {
		StringBuffer sb=new StringBuffer("");
		if(input<=3) {
			System.out.println("NO");
		}else {
			if(input==4) {
				sb.append("1 + 2 = 3,3 + 3 = 6,4 * 6 = 24,");
			}else if(input==5) {
				sb.append("1 + 2 = 3,3 * 4 = 12,5 - 3 = 2,12 * 2 = 24,");
			}else if(input>5) {
				if((input-4)%2==0) {
					sb.append("1 + 2 = 3,3 + 3 = 6,4 * 6 = 24,");
					for(int i=1;i<=(input-4)/2;i++) {
						int x=4+i*2;
						int y=4+i*2-1;
						sb.append(x+" - "+y+" = "+1+",");
						sb.append("1 * 24 = 24,");
					}
				}else {
					sb.append("1 + 2 = 3,3 * 4 = 12,5 - 3 = 2,12 * 2 = 24,");
					for(int i=1;i<=(input-5)/2;i++) {
						int x=5+i*2;
						int y=5+i*2-1;
						sb.append(x+" - "+y+" = "+1+",");
						sb.append("1 * 24 = 24,");
					}
				}
			}
			System.out.println("YES");
			//System.out.println(m.res.toString());
			String[] resArray=sb.toString().split(",");
			for(int i=0;i<resArray.length;i++)
				System.out.println(resArray[i]);
		}	
	}
	
	
	
	
	public void processor24_1(int input) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=1;i<=input;i++)
			list.add(i);
		StringBuffer sb=new StringBuffer("");
		dfs(list,sb);
	}
	
	public int dfs(ArrayList<Integer> list,StringBuffer sb) {
		if(list.size()==1&&list.get(0)==24) {
			res=sb;
			return 1;
		}else if(list.size()==1&&list.get(0)!=24) {
			return 0;
		}
		else {
			int x,y;
			for(int i=0;i<list.size()-1;i++) {
				for(int j=i+1;j<list.size();j++) {
					x=list.get(i);y=list.get(j);
					ArrayList<Integer> newlist;
					StringBuffer newsb;
					
					newlist=listclone(list);
					newsb=new StringBuffer(sb.toString());
					calculator(newlist,newsb,x,y,1);					
					if(dfs(newlist,newsb)==1)
						return 1;
					
					newlist=listclone(list);
					newsb=new StringBuffer(sb.toString());
					calculator(newlist,newsb,x,y,2);
					if(dfs(newlist,newsb)==1)
						return 1;
					
					newlist=listclone(list);
					newsb=new StringBuffer(sb.toString());
					calculator(newlist,newsb,x,y,3);
					if(dfs(newlist,newsb)==1)
						return 1;
					
					newlist=listclone(list);
					newsb=new StringBuffer(sb.toString());
					calculator(newlist,newsb,x,y,4);
					if(dfs(newlist,newsb)==1)
						return 1;
				}
			}
		}
		return 0;
	}
	
	public void calculator(ArrayList<Integer> newlist,StringBuffer sb,int x,int y,int type) {
		int n = 0;
		if(type==1) {
			n=x+y;
			sb.append(x+" + "+y+" = "+n+",");
		}else if(type==2) {
			n=x*y;
			sb.append(x+" * "+y+" = "+n+",");
		}else if(type==3) {
			n=x-y;
			sb.append(x+" - "+y+" = "+n+",");
		}else if(type==4) {
			n=y-x;
			sb.append(y+" - "+x+" = "+n+",");
		}
		newlist.remove(newlist.indexOf(x));newlist.remove(newlist.indexOf(y));
		newlist.add(n);
	}
	
	public ArrayList<Integer> listclone(ArrayList<Integer> list){
		ArrayList<Integer> newlist=new ArrayList<Integer>();
		for(int i=0;i<list.size();i++)
			newlist.add(list.get(i));
		return newlist;
	}

}
