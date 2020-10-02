package leetcode;

public class noLCP17 {

	public static void main(String[] args) {
		noLCP17 test=new noLCP17();
		System.out.println(test.calculate("AB"));
	}
	
    public int calculate(String s) {
    	
    	int x=1;
    	int y=0;
    	int res=0;
    	
    	for(int i=0;i<s.length();i++) {
    		char c=s.charAt(i);
    		if(c=='A') {
    			x=2*x+y;
    		}else {
    			y=2*y+x;
    		}
    	}
    	res=x+y;
    	
    	return res;
    }

}
