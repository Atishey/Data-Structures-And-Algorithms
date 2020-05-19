public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProduct(final List<Integer> al) {
        int n = al.size();
        int max[] = new int[n];
        int min[] = new int[n];
        int ans = 1;
        boolean isZero = false;
        int count = 0;
        if(al.get(0) == 0){
            isZero = true;
            count++;
            max[0] = min[0] = 1;
        }    
        else    
            ans = max[0] = min[0] = al.get(0);
        for(int i=1;i<n;i++){
            
            while(i<n && al.get(i) == 0){
                isZero = true;
                count++;
                if(ans < 0)
                    ans = 0;
                max[i] = 1;
                min[i] = 1;
                i++;
            }
            
            if(i == n)
                break;
                
            if(al.get(i) > 0){
                max[i] = Math.max(al.get(i),max[i-1]*al.get(i));
                min[i] = Math.min(al.get(i),min[i-1]*al.get(i));
            }
            else{
                max[i] = Math.max(al.get(i),min[i-1]*al.get(i));
                min[i] = Math.min(al.get(i),max[i-1]*al.get(i));
            }
            
            ans = Math.max(max[i],ans);
        }
        if(isZero && count == n)
            return 0;
        return ans;
    }
}
