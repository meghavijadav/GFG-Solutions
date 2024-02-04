//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    //Function to check if the number is sparse or not.
    public static boolean isSparse(int n)
    {
        // Your code here
        //The question is asking 
        //Basically the binary representation of the given number 
        //should not contain consecutive 1 
        if((n&(n>>1))>=1){
            //we are right shifiting on n and checking which new number we are getting 
            //so for example the number was 
            //010010000
            //001001000 this is what it wil become after shifiting it right once
            //000000000 we will get this on performing bitwise and operation of these two numbers
            //If it is not sparse it will not give all zeroes 
            return false;
        }
        return true;
    }
    
}


//{ Driver Code Starts.

class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//testcases
		int t = sc.nextInt();
		
		while(t-->0){
		    
		    		     
            //initializing n
		    int n = sc.nextInt();
		    
		    Solution obj = new Solution();
		    
		    //printing 1 if isSparse returns true
            //else 0
		    if(obj.isSparse(n)){
		        System.out.println("1");
		    } else {
                System.out.println("0");
		    }
		}
	}
}
// } Driver Code Ends