//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[]) {
        // code here
        if(n ==0){
            return 0;
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int num : a){
            int pos = Collections.binarySearch(ans, num);
            
            if(pos < 0){
                pos = -(pos+1);
            }   
            
            
            if(pos >= ans.size()){
                ans.add(num);
            }else{
                ans.set(pos, num);
            }
        }
        return ans.size();
    }
}