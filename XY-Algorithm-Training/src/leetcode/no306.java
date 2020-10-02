package leetcode;

public class no306 {

	public static void main(String[] args) {
		no306 test=new no306();
		System.out.println(test.isAdditiveNumber("101"));
	}
    public boolean isAdditiveNumber(String num) {
    	if(num.length()<2){
            return false;
        }
    	int i=0,j,k;
    	for(j=i+1;j<num.length();j++) {
    		for(k=j+1;k<num.length();k++) {
    			if(backTrace(num,i,j,k))return true;
    		}
    	}
    	return false;
    	
    }
    public boolean backTrace(String num,int i,int j,int k) {
    	if(num.charAt(i)=='0'||num.charAt(j)=='0') {
    		return false;
    	}
    	//System.out.println(i+" "+j+" "+k);
    	String v1=num.substring(i, j);
    	String v2=num.substring(j, k);
    	String sumStr=add(v1,v2);
    	if(sumStr.length()+k>num.length()||!sumStr.equals(num.substring(k,k+sumStr.length()))) {
    		return false;
    	}
    	if(sumStr.length()+k==num.length())return true;
    	return backTrace(num,j,k,k+sumStr.length());
    	
    }
    public String add(String s1, String s2) {
    	char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		int len1 = a1.length;
		int len2 = a2.length;
		int i = len1 - 1, j = len2 - 1;
		int m = 0; //当前位上要相加的数
		int n = 0; //余数
		int num1 = 0, num2 = 0;
		StringBuffer s = new StringBuffer();
		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				num1 = a1[i] - '0';
			} else {
				num1 = 0;
			}
			if (j >= 0) {
				num2 = a2[j] - '0';
			} else {
				num2 = 0;
			}		
			int sum = num1 + num2 + n;
			m = sum % 10;
			n = sum / 10;
			char c = (char)(m + '0');
			s.append(c);
			i--;
			j--;
		}
		if (n != 0) {
			s.append('1');
		}
		
		s.reverse();
		return s.toString();
    }
    

}
