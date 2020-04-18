//Hackerrank problem - https://www.hackerrank.com/challenges/abbr/problem?h_r=internal-search&isFullScreen=true

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static boolean vis[][];
    static boolean dp[][];

    // Complete the abbreviation function below.
    static boolean isPossible(int i,int j,String a, String b){
        
        if(i == a.length() && j == b.length())
            return true;
        if(i == a.length())
            return false;    
        if(vis[i][j])
            return dp[i][j];
        vis[i][j] = true;    
        if(j == b.length()){
            if(Character.isUpperCase(a.charAt(i)))
                return dp[i+1][j] = false;
            return dp[i+1][j] = isPossible(i+1,j,a,b);     
        }
        if(a.charAt(i) == b.charAt(j))
            return dp[i][j] = isPossible(i+1,j+1,a,b);
        else{
            if(Character.isUpperCase(a.charAt(i)))
                return dp[i][j] = false;
            if(Character.toUpperCase(a.charAt(i)) == b.charAt(j))
                return dp[i][j] = isPossible(i+1,j+1,a,b) || isPossible(i+1,j,a,b);
            return dp[i][j] = isPossible(i+1,j,a,b);        

        }    

    }
    static String abbreviation(String a, String b) {
        vis = new boolean[a.length()+1][b.length()+1];
        dp = new boolean[a.length()+1][b.length()+1];
        if(a.length() < b.length())
            return "NO";
        return isPossible(0,0,a,b) ? "YES" : "NO";    

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
