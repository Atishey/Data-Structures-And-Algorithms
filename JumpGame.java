//O(n2) solution using top down approach - dp
class Solution {
    boolean ans[],vis[];
    
    boolean isPossible(int[] a, int index){
        if(vis[index])
            return ans[index];
        vis[index] = true;
        for(int i=1;index+i<a.length && i <= a[index] ;i++){
            
            if(index+i == a.length-1 || isPossible(a,index+i))
                return true;
            
            ans[index+i] = false;
        }
        ans[index] = false;
        return false;
    }
    
    public boolean canJump(int[] nums) {
        vis = new boolean[nums.length];
        ans = new boolean[nums.length];
        if(nums.length <= 1)
            return true;
        if(nums[0] == 0)
             return false;   
        return isPossible(nums,0))
         
        
    }
    
}
