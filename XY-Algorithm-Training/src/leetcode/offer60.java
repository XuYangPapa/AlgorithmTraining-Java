package leetcode;

public class offer60 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    public double[] twoSum(int n) {
    	int[][]dp=new int[n+1][6*n+1];
    	for(int s=1;s<=6;s++)
    		dp[1][s]=1;
    	for(int i=2;i<=n;i++){
            for(int s=i;s<=6*i;s++){
                for(int d=1;d<=6;d++){
                    if(s-d<i-1)break;
                    dp[i][s]+=dp[i-1][s-d];
                }
            }
        }
    	double total = Math.pow(6,n);
        double[] res = new double[5*n+1];
        for(int i=n;i<=6*n;i++){
            res[i-n]=(dp[n][i])/total;
        }
        return res;
    }

}
