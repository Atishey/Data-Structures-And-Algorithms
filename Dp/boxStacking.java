public class Solution {
    class Box implements Comparable{
        int l,w,h;
        long area;
        Box(int l,int w,int h){
            this.l = l;
            this.w = w;
            this.h  = h;
            area = (long)l*w;
        }
        @Override
        public int compareTo(Object ob1){
            return Long.compare(((Box)ob1).area,this.area);
        }
    }
    public int solve(int[][] a) {
        int n  = a.length;
        Box boxes[] = new Box[3*n];
        
        for(int i=0;i<n;i++){
            int dim[] = new int[3];
            dim[0] = a[i][0];
            dim[1] = a[i][1];
            dim[2] = a[i][2];
            Arrays.sort(dim); 
            /*
            We are sorting this as we are assuming length will be always amaller than width and accordingly we have inserted
            dimensions below.
            */

            boxes[3*i] = new Box(dim[2],dim[1],dim[0]);
            boxes[3*i+1] = new Box(dim[2],dim[0],dim[1]);
            boxes[3*i+2] = new Box(dim[1],dim[0],dim[2]);
        }
        
        Arrays.sort(boxes);
        int dp[] = new int[3*n];
        int ans = 0;
        for(int i=0;i<boxes.length;i++){
            Box cur_box = boxes[i];
            dp[i] = cur_box.h;
            for(int j=0;j<i;j++){
                if(cur_box.w < boxes[j].w && cur_box.l < boxes[j].l){
                    dp[i] = Math.max(dp[i],dp[j]+cur_box.h);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
