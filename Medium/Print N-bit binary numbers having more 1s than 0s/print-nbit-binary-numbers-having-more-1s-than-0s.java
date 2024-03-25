//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> arr = new ArrayList<>();
        String curr = "";
        solve(arr, curr, 0, 0, N);
        return arr;
    }

    private void solve(ArrayList<String> arr, String curr, int one, int zero, int n) {
        if (one < zero) return;

        if (curr.length() == n) {
            arr.add(curr);
            return;
        }

        solve(arr, curr + "1", one + 1, zero, n);
        solve(arr, curr + "0", one, zero + 1, n);
    }
    
}