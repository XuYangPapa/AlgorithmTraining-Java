package leetcode;

public class no1208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcd";
		String t="bcdf";
		equalSubstring(s,t,3);
	}
    public static int equalSubstring(String s, String t, int maxCost) { 	
    	int i=0,j=0;
    	int currentCost=0;
    	int maxLength=0;
    	while(i<s.length()&&j<t.length()) {
    		currentCost+=Math.abs(s.charAt(j)-t.charAt(j));
    		if(currentCost>maxCost) {
    			currentCost-=Math.abs(s.charAt(i)-t.charAt(i));
    			System.out.println(i+"  "+j+"--"+currentCost);
    			i++;
    		}else {
    			if(j-i+1>maxLength)maxLength=j-i+1;
    			System.out.println(i+"  "+j+"--"+currentCost);
    			j++;
    		}
    	}
    	System.out.println(maxLength);
    	return maxLength;
    }

}
