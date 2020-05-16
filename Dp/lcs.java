/* Longest common subsequence problem*/

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
	        int n1 = sc.nextInt();
	        int n2 = sc.nextInt();
	        String s1 = sc.next();
	        String s2 = sc.next();
	        int dp[][] = new int[n1+1][n2+1];
	        for(int i=1;i<=n1;i++){
	            for(int j=1;j<=n2;j++){
	               if(s1.charAt(i-1) == s2.charAt(j-1))
	                    dp[i][j] = 1+dp[i-1][j-1];
	               else
	                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
	                
	            }
	        }
	        System.out.println(dp[n1][n2]);
	        t--;
	    }
	 }
}
