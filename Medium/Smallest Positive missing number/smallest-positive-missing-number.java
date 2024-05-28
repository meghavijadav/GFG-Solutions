//{ Driver Code Starts
import java.util.*;
import java.io.*;


// } Driver Code Ends

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        
        //Approach 
        //traverse the array
        //ignore negative numbers 
        //counter start and with i increase the counter unless you find a positive number
        //now match the counter to the numbers 
        // int n= arr.length; 
        // boolean[] A = new boolean[n + 1];
        
        // for(int i = 0; i < size; i++){
        //     A[arr[i]] = true;
        // }
        
        // for(int i = 0; i <= size; i++){
        //     if(!A[i]){
        //         return i;
        //     }
        // }
        // return size + 1;
        // int n = arr.length;
        // int count = 1;
        // for(int i = 0; i < n; i++){
        //     if(arr[i] < 0){
        //         continue;
        //     }else{
        //         if(arr[i] == count){
        //             count++;
        //         }
        //     }
        // }
        // return count;
        
        Arrays.sort(arr);
        int n = arr.length;
        int count = 1;
         for(int i = 0; i < n; i++){
             if(arr[i] == count){
                 count++;
             }
         }
        return count;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) throws IOException
    {

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
        //taking testcases
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    
		    //input number n
			int n=Integer.parseInt(in.readLine().trim());
			int[] arr=new int[n];
			String s[]=in.readLine().trim().split(" ");
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(s[i]);
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			out.println(missing);
		}
		out.close();
    }
}


// } Driver Code Ends