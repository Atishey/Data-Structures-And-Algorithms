import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static int n,W,val[],wt[],dp[],res = 0; 
    public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    while(t>0) {
	        
	        n = Integer.parseInt(br.readLine());
	        W = Integer.parseInt(br.readLine());
	        wt = new int[n];
	        val = new int[n];
	        String s1[] = br.readLine().split(" ");
	        for(int i=0;i<n;i++)
	            val[i] = Integer.parseInt(s1[i]);
	       String s2[] = br.readLine().split(" ");     
	       for(int i=0;i<n;i++)
	            wt[i] = Integer.parseInt(s2[i]);
	        dp = new int[W+1];
	        for(int i=0;i<n;i++){
	            for(int j=W;j>=wt[i];j--){
	                    dp[j] = Math.max(val[i] + dp[j-wt[i]],dp[j]);
	            }
	        }
	        System.out.println(dp[W]);     
	        t--;
	    }
	 }
}
