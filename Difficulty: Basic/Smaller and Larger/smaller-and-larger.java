//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {

            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }
            int x = Integer.parseInt(read.readLine().trim());
            Solution obj = new Solution();
            // Get results and print
            int[] result = obj.getMoreAndLess(nums, x);
            System.out.println(result[0] + " " + result[1]);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] getMoreAndLess(int[] arr, int x) {
        // code here
        int l = 0;
        int m = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x) {
                l++;
            }
            if (arr[i] >= x) {
                m++;
            }
        }
        
        return new int[]{l, m};
    }
}