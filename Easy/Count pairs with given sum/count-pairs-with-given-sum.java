//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        //Approach
        //The function iterates over the array arr from index 0 to n-1, 
        //where n is the size of the array.
        //For each element arr[i], it checks if k - arr[i] is present in the map.
        //If it is, it means that there exists another element in the array such that their sum is k. 
        //If such a pair exists, the count is incremented by the value corresponding to k - arr[i] in the map.
        //For each element arr[i], its frequency in the array is updated in the HashMap.
        //Finally, the count of pairs that sum up to k is returned.
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(k - arr[i])) {
                count += map.get(k - arr[i]);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}
