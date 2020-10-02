package leetcode;

public class no7 {

	public static void main(String[] args) {
		no7 test=new no7();
		System.out.println(test.reverse(1534236469));
	}
	
	public int reverse(int x) {
		StringBuilder str=new StringBuilder(String.valueOf(x));
		str=str.reverse();
		if(str.charAt(str.length()-1)=='-') {
			str.insert(0, '-');
			str.setCharAt(str.length()-1, ' ');
		}
		try {
			int res=Integer.valueOf(str.toString().trim());	
			return res;
		}catch(Exception e) {
			return 0;
		}
		
		
    }

}
