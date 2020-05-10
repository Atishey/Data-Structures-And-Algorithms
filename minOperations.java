import java.util.*;
class GFG
 {
    static int ans = Integer.MAX_VALUE;
    static int dp[];
    public static int printMinOperations(int n,int i,int count){
        if(i == 0){
            return dp[n] = count;
        }
        
        if(dp[i] != Integer.MAX_VALUE)
            return dp[i];
            
        if(i%2 == 0){    
            int option1 = printMinOperations(n,i/2,count+1);
            int option2 = printMinOperations(n,i-1,count+1);
            dp[i] = Math.min(Math.min(dp[i],option1),option2);
        }
        else
            dp[i] = Math.min(dp[i],printMinOperations(n,i-1,count+1));
        return dp[i];
    } 
    
	public static void main (String[] args) throws IOException
	 {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   int t = Integer.parseInt(br.readLine());
	    while(t>0) {
	        int n = Integer.parseInt(br.readLine());
	        dp = new int[n+1];
	        Arrays.fill(dp,Integer.MAX_VALUE);
	        System.out.println(printMinOperations(n,n,0));
	        t--;
	    }
	 }
}
