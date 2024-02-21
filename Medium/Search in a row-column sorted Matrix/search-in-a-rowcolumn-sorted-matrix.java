//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
	public static void main(String args[]) throws IOException { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int rows=sc.nextInt();
       		int columns=sc.nextInt();
			
			int matrix[][]=new int[rows][columns];
          
        	for(int i=0; i<rows;i++){            
            	for(int j=0; j<columns;j++){
                	matrix[i][j]=sc.nextInt();
            	}
         	}
         	int target = sc.nextInt();
         	
			Solution x = new Solution();
			
			if (x.search(matrix, rows, columns, target)) 
				System.out.println(1); 
			else
				System.out.println(0); 
			t--;
		}
	} 
}
// } Driver Code Ends




class Solution 
{ 
    //Function to search a given number in row-column sorted matrix.
	static boolean search(int matrix[][], int n, int m, int x) 
	{  
	    // code here 
	    //We will use two for loops for each row and each col
	    //O(nxm)
	    //if matrix[i][j] == x return true else keep checking
	    //in the end if you dont find anything return false
	    //Brute Force Approach
	    //matrix[][] = {{ 3, 30, 38},
            //   {36, 43, 60},
            //   {40, 51, 69}}
        //lets say for this example if I choose 38 and lets say the target element is 62
        //we know 62 > 32
        //because we chose 38 which is the top and right mose element 
        //if we go { 3, 30, 38} behind 38 in this row its useless
        //so we need to move downwards 
        //lets say if the target element was 32 then we know it is less than 38 
        //so we can delete the whole last column so you should decrement the count of j
        
        //We could also visualize it as a 1D array and apply binary search to it
        //But then you will have to do (index)%3
        
        int i = 0;
        int j = m - 1; // m is number of column
        
        while(i < n && j >= 0){
            if(matrix[i][j] == x){
                return true;
            }
            else if(matrix [i][j] < x){
                i++;
            }else{
                j--;
            }
        }
        return false;
	}    
} 
