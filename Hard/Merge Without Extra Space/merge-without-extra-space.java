//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        //Aproach 
        //first merge the two arrays 
        //now sort them 
        // now spit the first n numbers and remaining m numbers
        
        // Step 1: Merge the two arrays
        long[] mergedArray = new long[n + m];
        for (int i = 0; i < n; i++) {
            mergedArray[i] = arr1[i];
        }
        for (int j = 0; j < m; j++) {
            mergedArray[n + j] = arr2[j];
        }

        // Step 2: Sort the merged array
        Arrays.sort(mergedArray);

        // Step 3: Split the sorted array into the first n numbers and remaining m numbers
        for (int i = 0; i < n; i++) {
            arr1[i] = mergedArray[i];
        }
        for (int j = 0; j < m; j++) {
            arr2[j] = mergedArray[n + j];
        }
    }
}
