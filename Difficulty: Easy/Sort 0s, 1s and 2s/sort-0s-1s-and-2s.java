//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public void sort012(ArrayList<Integer> arr) {
        int left = 0;
        int mid = 0;
        int right = arr.size() - 1;

        while (mid <= right) {
            if (arr.get(mid) == 0) {
                int temp = arr.get(left);
                arr.set(left, arr.get(mid));
                arr.set(mid, temp);
                left++;
                mid++;
            } else if (arr.get(mid) == 1) {
                mid++;
            } else {
                int temp = arr.get(right);
                arr.set(right, arr.get(mid));
                arr.set(mid, temp);
                right--;
            }
        }
    }
}
