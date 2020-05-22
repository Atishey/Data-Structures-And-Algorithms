   //https://practice.geeksforgeeks.org/problems/edit-distance/0
   
    static String s1,s2;
    static int n1,n2,dp[][];
    
    public static int editDistance(int i,int j){
        if(i == 0 || j == 0)
            return dp[i][j];
        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }    
        if(s1.charAt(i-1) == s2.charAt(j-1)) {
            dp[i][j] = editDistance(i-1,j-1);
        }
        else{
            int option1 = editDistance(i,j-1);
            int option2 = editDistance(i-1,j);
            int option3 = editDistance(i-1,j-1);
            dp[i][j] = 1 + Math.min(option1,Math.min(option2,option3));
        }
        return dp[i][j];
    }    
    
	public static void main (String[] args) throws IOException {
	   FastReader sc = new FastReader();
	   int t = sc.nextInt();
	    while(t>0) {
	        n1 = sc.nextInt();
            n2 = sc.nextInt();
            s1 = sc.next();
            s2 = sc.next();
            dp = new int[n1+1][n2+1];
            for(int i=1;i<=n1;i++)
                dp[i][0] = i;
            for(int i=1;i<=n2;i++)
                dp[0][i] = i;
            for(int i=1;i<=n1;i++)
                for(int j=1;j<=n2;j++)
                    dp[i][j] = Integer.MAX_VALUE;
                    
            System.out.println(editDistance(n1,n2));
	        t--;
	    }
	 }
