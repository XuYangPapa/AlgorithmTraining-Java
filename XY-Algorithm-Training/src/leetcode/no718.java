package leetcode;

public class no718 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {1,2,3,4,5,4,5,3};
		int[] B= {1,4,3,5,7,8};
		findLength(A,B);

	}

    public static int findLength(int[]A,int[]B) {
    	int[] xArray=new int[A.length];
    	int[] yArray=new int[A.length];
    	int a,b;
    	int max=0;
    	for(b=0;b<B.length;b++) {
    		for(a=0;a<A.length;a++) {
    			if(A[a]==B[b]) {
					if(a==0)yArray[a]=1;
					else yArray[a]=xArray[a-1]+1;
				}else {
					if(a==0)yArray[a]=0;
					else yArray[a]=Math.max(yArray[a-1], xArray[b]);	
					//else yArray[a]=0;	
				}
    			if(yArray[a]>max)max=yArray[a];
    	    }
    		for(int i=0;i<A.length;i++) {
    			xArray[i]=yArray[i];
    			yArray[i]=0;
    		}	   		
    	}  	
    	System.out.print(max);
    	return max;
    }

}

