//https://www.interviewbit.com/problems/russian-doll-envelopes/

public class Solution {
    class Envelope implements Comparable{
        int w;
        int h;
        Envelope(int h,int w){
            this.h = h;
            this.w = w;
        }
        
        @Override
        public int compareTo(Object o){
            Envelope e = (Envelope)o;
            return -Integer.compare(this.w,e.w);
        }
    }
    public int solve(int[][] a) {
        int n = a.length;
        Envelope envelopes[] = new Envelope[n];
        for(int i=0;i<n;i++){
            envelopes[i] = new Envelope(a[i][0],a[i][1]);
        }
        Arrays.sort(envelopes);
        int ans = 0;
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = 1;
            int val = dp[i];
            for(int j=0;j<i;j++){
                if(envelopes[i].w < envelopes[j].w && envelopes[i].h < envelopes[j].h)
                    val = Math.max(dp[i]+dp[j],val);
            }
            dp[i] = val;
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}
