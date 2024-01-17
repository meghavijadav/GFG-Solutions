//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
         if (arr == null || n == 0) {
            return "-1";
        }

        String prefix = arr[0]; // Take the first string as the initial prefix

        for (int i = 1; i < n; i++) {
            int j = 0;
            while (j < prefix.length() && j < arr[i].length() && prefix.charAt(j) == arr[i].charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j); // Update the prefix based on the current string
        }

        return (prefix.length() == 0) ? "-1" : prefix;
        
    }
}
