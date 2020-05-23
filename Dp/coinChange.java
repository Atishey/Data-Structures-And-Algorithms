   /* https://practice.geeksforgeeks.org/problems/coin-change/0 */
   static int a[],dp[][];
    public static int countWays(int m,int n) {
        if(n == 0)
            return 1;
        if(m < 0 || n < 0)
            return 0;
        if(dp[m][n] != -1)
            return dp[m][n];
        int ans = 0;    
        ans = countWays(m,n-a[m]) + countWays(m-1,n);
        return dp[m][n] = ans;
        
    }
	public static void main (String[] args) throws IOException {
	   FastReader sc = new FastReader();
	   int t = sc.nextInt();
	   while(t>0) {
	        int m = sc.nextInt();
	        a = new int[m];
	        
	        for(int i=0;i<m;i++){
	            a[i] = sc.nextInt();
	        }
	        int n = sc.nextInt();
	        dp = new int[m][n+1];
	        for(int i=0;i<m;i++)
	            Arrays.fill(dp[i],-1);
	        System.out.println(countWays(m-1,n));
	        t--;
	    }
	 }

//Space optimised bottom up approach

static int a[],dp[];
    
public static void main (String[] args) throws IOException {
   FastReader sc = new FastReader();
   int t = sc.nextInt();
   while(t>0) {
	int m = sc.nextInt();
	a = new int[m];

	for(int i=0;i<m;i++){
	    a[i] = sc.nextInt();
	}
	int n = sc.nextInt();
	//Array storing no. of ways to get value n when m coins are given.
	dp = new int[n+1];
	dp[0] = 1;

	for(int i=0;i<m;i++){
	    for(int j=a[i];j<=n;j++){
	    dp[j] += dp[j-a[i]];
	    }
	} 
	System.out.println(dp[n]);
	t--;
    }
 }
