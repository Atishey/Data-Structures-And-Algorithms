import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	   //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   //int t = Integer.parseInt(br.readLine());
	    while(t>0) {
	        int n  = sc.nextInt();
	        int lis[] = new int[n];
	        int dp[] = new int[n];
	        for(int i=0;i<n;i++){
	            lis[i] = sc.nextInt();
	        }
	        
	        dp[0] = 1;
	        int ans = 1;
	        for(int i=1;i<n;i++){
	            int max = -1;
	            for(int j=0;j<i;j++){
    	            if(lis[j] < lis[i])
    	                max = Math.max(max,1 + dp[j]);
    	            
	            }
              /*
              If we don't find any value of j that is greater than i,
              then lis ending at i will be 1 as element at i is the greatest value till i.
              */
	            if(max != -1) 
	                dp[i] = max;
	            else
	                dp[i] = 1;
	           ans = Math.max(ans,dp[i]);     
	        }
	        System.out.println(ans);
	        
	        
	        t--;
	    }
	 }
}
