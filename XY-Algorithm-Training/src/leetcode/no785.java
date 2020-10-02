package leetcode;

import java.util.HashSet;

public class no785 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	byte[] array;
	public boolean isBipartite(int[][] graph) {
		array=new byte[graph.length];
		for(int i=0;i<array.length;i++) {
			if(array[i]!=0)continue;
			array[i]=1;
			for(int j=0;j<graph[i].length;j++) {
				if(dfs(graph,graph[i][j],array[i])==false)return false;
			}
		}
		return true;
    }
	public boolean dfs(int[][] graph,int node,byte pre) {
		if(array[node]==pre)return false;
		else if(array[node]==0) {
			array[node]= (byte) ~pre;	
			for(int i=0;i<graph[node].length;i++) {
				if(dfs(graph,graph[node][i],array[node])==false)return false;
			}
			return true;
		}else {
			return true;
		}
	}

}
