//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int a[], int n) {
       //Approach 
       //You are given and ArrayList 
       //You need to first sort the array list 
       //Start a pointer if you find out that the number on the index n = n + 1 then return that number
       //now increment that pointer and continue to find the numbers where n = n+1 till the arr.length
       //else return -1 if there are no duplicates
        ArrayList<Integer> dup = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        
        for (int num : a) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > 1) {
                dup.add(entry.getKey());
            }
        }
        
        if (dup.isEmpty()) {
            dup.add(-1);
        } else {
            dup.sort(null);
        }
        
        return dup;
    }
}
