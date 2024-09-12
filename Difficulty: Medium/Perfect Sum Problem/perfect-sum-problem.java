//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


// class Solution {
    
//     public static final int MOD = 1000000007;
//     public int f(int index, int sum, int arr[], int[][] dp) {
//         if (sum == 0) {
//             return 1;
//         }

//         // if (index == 0) {
//         //     return (arr[0] == sum) ? 1 : 0;
//         // }
        
//         if(index < 0){
//             return 0;
//         }
        
//         if(sum < 0){
//             return 0;
//         }

//         if (dp[index][sum] != -1) {
//             return dp[index][sum];
//         }

//         int notPick = f(index - 1, sum, arr, dp);

//         int pick = 0;
//         if (arr[index] <= sum) {
//             pick = f(index - 1, sum - arr[index], arr, dp);
//         }

//         dp[index][sum] = (pick + notPick)%MOD;
//         return dp[index][sum];
//     }

//     public int perfectSum(int arr[], int n, int sum) { 
//         int[][] dp = new int[n][sum + 1];
//         for (int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }
        
//         return f(n - 1, sum, arr, dp);
//     }
// }

class Solution {
    private static final int MOD = 1000000007;

    public int fun(int i, int s, int[] arr, int[][] dp) {
        if (i == 0) {
            if (s == 0 && arr[i] == 0) {
                return 2;
            }
            if (s == 0 || arr[i] == s) {
                return 1;
            }
            return 0;
        }

        if (dp[i][s] != -1) {
            return dp[i][s];
        }

        int take = (arr[i] <= s) ? fun(i - 1, s - arr[i], arr, dp) % MOD : 0;
        int notTake = fun(i - 1, s, arr, dp) % MOD;

        return dp[i][s] = (take + notTake) % MOD;
    }
    
    public int perfectSum(int[] arr, int n, int sum) {
        int[][] dp = new int[n][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return fun(n - 1, sum, arr, dp) % MOD;
    }
}

