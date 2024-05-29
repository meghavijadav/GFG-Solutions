//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.findWinner(n, x, y);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findWinner(int n, int x, int y) {
        // code here
        int[] dp = new int[n + 1];
        for(int i = 0; i < n; i++){
            if(dp[i] == 0){
                if (i + 1 <= n) {
                    dp[i + 1] = 1;
                }
                if(i + x <= n){
                    dp[i + x] = 1;
                }
                if(i + y <= n){
                    dp[i + y] = 1;
                }
            }
        }
        return dp[n];
    }
}
