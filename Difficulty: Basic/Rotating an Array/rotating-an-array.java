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

            int d = Integer.parseInt(read.readLine().trim());

            new Solution().leftRotate(nums, d);
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void leftRotate(int arr[], int d) {
        // code here
        int n = arr.length;
        d=d%n;
        int[] temp = new int[n];
        int count=0;
        for(int i=d;i<n;i++){
            temp[count] = arr[i];
            count++;
        }
        for(int i=0;i<d;i++){
            temp[count+i]=arr[i];
        }
        System.arraycopy(temp,0,arr,0,n);
    }
}
