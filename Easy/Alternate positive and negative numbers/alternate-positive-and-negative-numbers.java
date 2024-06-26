//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            
            if(arr[i]<0){
                list2.add(arr[i]);
            }else{
                list1.add(arr[i]);
            }
            
        }
        
        int idx = 0;
        int i=0;
        int j=0;
        
        for(i=0,j=0; i<list1.size() || j<list2.size(); i++,j++){
            
            if(i<list1.size()){
            arr[idx++] = list1.get(i);
            }
            
            if(j<list2.size()){
            arr[idx++] = list2.get(j);
            }
        }    
    }
}