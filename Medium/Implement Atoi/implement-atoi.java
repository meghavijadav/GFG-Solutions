//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
    	int num = 0;
    	if(s.charAt(0)=='-'){
    	    for(int i = 1; i < s.length(); i++){
    	        int c = s.charAt(i)-'0'; 
    	    if(c>=0 && c<=9){
    	        num = num*10+c; 
    	    }
    	    else{
    	    return -1;
    	    }

    	    }
    	    return -1*num;
    	    
        }  
        for(int i = 0; i<s.length();i++){
            int c = s.charAt(i)-'0';
            if(c>=0 && c<=9){
                num = num*10+c;
            }
            else{
            return -1;
            }
        }
        return num;
    }
}
