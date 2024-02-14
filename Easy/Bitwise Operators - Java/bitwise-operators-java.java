//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) {

        // taking input using scanner class
        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();

        while (testcases-- > 0) {

            // taking a,b,c
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // creating an object of class Geeks
            Geeks g = new Geeks();

            // calling the method bitWiseOp()
            // of class Geeks and passing
            // a,b,c as arguments
            g.bitWiseOp(a, b, c);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// Function to perform bitwise manipulations
// a, b and c are input integers
class Geeks {
    static void bitWiseOp(int a, int b, int c) {

        // Your code here
        System.out.println(a^a);
        System.out.println(c ^ b);
        System.out.println(a & b);
        System.out.println(c | (a ^ a));
        System.out.println(~(c ^ b));

    }
}