//{ Driver Code Starts
// Java program to demonstrate working of Scanner in Java
import java.util.*;
import java.io.*;
class Abc
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int[] a[],b;
            a= new int[n][n];
            b= new int[n];
            int sum=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    int p=sc.nextInt();
                    a[i][j]=p;
                }
            }
            int Max=0;
            for(int i=0;i<n;i++)
            {
                int p=sc.nextInt();
                b[i]=p;
            }
            Complete obj = new Complete();
            ArrayList<Integer> ans;
            ans = obj.array(a, b, n);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


class Complete
{
    public static ArrayList<Integer> array(int a[][], int b[], int n)
    {
        // Complete the function
        // int sum = 0;
        // int max = 0;
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         sum = a[0][0] + a[1][1] + a[2][2];
        //         if(b[i] > max){
        //             max = b[i];
        //         }
        //     }
        // }
        // return new ArrayList<Integer>(Arrays.asList(sum, max));
        
        int sum = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            sum += a[i][i];
            if(b[i] > max){
                max = b[i];
            }
            
        }
        return new ArrayList<Integer>(Arrays.asList(sum, max));
    }
}
