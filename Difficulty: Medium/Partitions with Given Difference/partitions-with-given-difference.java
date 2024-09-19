//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    private static int MOD = 1000000007;
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int sum = 0; 
        for(int it : arr){
            sum += it;
        }
        
        if(sum - d < 0 || (sum-d)%2 != 0) return 0;
        return findWays(arr, (sum-d)/2, n);
    }
    
    public static int findWays(int[] arr, int d, int n){
        int[][] dp = new int[n][d+1];
        
        dp[0][0] = 1;
        
        if(arr[0] == 0){
            dp[0][0] = 2;
        }
        // else{
        //     dp[0][0] = 1;
        // }
        
        if(arr[0] != 0 && arr[0] <= d){
            dp[0][arr[0]] = 1;
        }
        
        for(int ind = 1; ind < n; ind++){
            for(int sum = 0; sum <= d; sum++){
                int notTaken  = dp[ind-1][sum];
                int take = 0;
                
                if(arr[ind] <= sum){
                    take = dp[ind-1][sum - arr[ind]];
                }
                dp[ind][sum] = (notTaken + take)%MOD;
            }
        }
        return dp[n-1][d];
    }
}
        
 