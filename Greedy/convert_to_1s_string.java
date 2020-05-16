/*
Binary Strings - Scaler problem
Problem Description
You are given a string A consisting of 1's and 0's. Now the task is to make the string consisting of only 1's. But you are allowed to perform only the following operation:
Take exactly B consecutive elements of string and change 1 to 0 and 0 to 1.
 Each operation takes 1 unit time so you have to determine the minimum time required to make the string of 1's only. If not possible return -1.  


Problem Constraints
2 ≤ length of A ≤ 1000
2 ≤ B ≤ (length of A)


Input Format
First argument is a string A consisting if 1's and 0's.
Second argument is an integer B which represents the number of consecutive elements which can be changed.


Output Format
Return an integer which is the minimum time to make the string of 1's only or -1 if not possible.

*/

public class Solution {
    char c[];
    public void flip(int start,int end){
        for(int i=start;i<=end;i++)
            c[i] = (c[i] == '0') ? '1' : '0';
    }
    public int solve(String s, int k) {
        int n = s.length();
        c = s.toCharArray();
        int ans = 0;
        for(int i=0;i<n;i++){
            if(c[i] == '0'){
                ans++;
                if(i+k-1 < n)
                    flip(i,i+k-1);
                else
                    return -1;
            }
        }
        return ans;
    }
}
