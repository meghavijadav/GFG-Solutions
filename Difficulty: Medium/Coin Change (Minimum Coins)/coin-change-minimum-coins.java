//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int m = sc.nextInt();
            int coins[] = new int[m];
            for (int i = 0; i < m; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minCoins(coins, m, v));
        }
    }
}
// } Driver Code Ends


class Solution {

    public int minCoins(int coins[], int M, int sum) {
        // Your code goes here
        int[][] dp = new int[M][sum+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int result = f(M-1, coins, M, sum, dp);
        return result == Integer.MAX_VALUE ? -1 : result; 
    }
    
    public static int f(int ind, int[] coins, int M, int sum, int[][] dp){
        if(sum == 0) return 0;
        if(ind == 0){
            if(sum%coins[0] == 0){
                return sum/coins[0];
            }else{
                return Integer.MAX_VALUE;
            }
        }
        
        if(dp[ind][sum] != -1){
            return dp[ind][sum];
        }
        
        int notTaken  = 0 + f(ind-1, coins, M, sum, dp);
        int taken = Integer.MAX_VALUE;
        if(coins[ind] <= sum){
            int res = f(ind, coins, M, sum - coins[ind], dp);
            if(res != Integer.MAX_VALUE){
                taken = 1 + res;
            }
        }
        dp[ind][sum] = Math.min(taken, notTaken);
        return dp[ind][sum];
        
    }
}