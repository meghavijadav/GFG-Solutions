//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) { 
        
        int maxDiff = -1;
        int maxRight[] = new int[n];
        int minLeft[] = new int[n];

        minLeft[0] = a[0];
        for (int i = 1; i < n; ++i)
            minLeft[i] = Math.min(a[i], minLeft[i - 1]);

        maxRight[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; --i)
            maxRight[i] = Math.max(a[i], maxRight[i + 1]);

        int i = 0, j = 0;
        while (i < n && j < n) {
            if (minLeft[i] <= maxRight[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else
                i++;
        }
        return maxDiff;
        
    }
}


