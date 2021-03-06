/*
You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. Your task is to complete the function maxChainLen which returns an integer denoting the longest chain which can be formed from a given set of pairs. 

Input:
The first line of input contains an integer T denoting the no of test cases then T test cases follow .Then T test cases follow . The first line of input contains an integer N denoting the no of pairs . In the next line are 2*N space separated values denoting N pairs.

Output:
For each test case output will be the length of the longest chain formed.

Constraints:
1<=T<=100
1<=N<=100

Example(To be used only for expected output):
Input
2
5
5  24 39 60 15 28 27 40 50 90
2
5 10 1 11 

Output
3
1
Explanation
(i) the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} },the longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}
(ii) The max length chain possible is only of length one.
*/

int maxChainLength(Pair arr[], int n)
    {
        Arrays.sort(arr,new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                return Integer.compare(p1.y,p2.y);
            }    
        });
        int ans = 0;
        Pair prev = arr[0];
        for(int i=1;i<arr.length;i++){
            if(prev.y < arr[i].x){
                ans++;
                prev = arr[i];
            }    
        }
        return ans+1;
    }
