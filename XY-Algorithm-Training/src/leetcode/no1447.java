package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class no1447 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    public List<String> simplifiedFractions(int n) {
    	List<String> resList=new LinkedList<String>();
    	
    	if(n==1)return resList;
    	
    	HashMap<Integer,Integer> tempMap=new HashMap<Integer,Integer>();
    	
    	for(int i=2;i<=n;i++) {
    		for(int j=1;j<i;j++) {
    			boolean sign=true;
    			int com=2;
    			while(com<=j+1/2) {
    				if(i%com==0&&j%com==0) {
    					sign=false;break;
    				}
    				com++;					   				
    			}
    			if(sign) {
    				String s=String.valueOf(j)+"/"+String.valueOf(i);
    				resList.add(s);
    			}
    		}
    	}
    	return resList;
    	
    }
    
 

}
