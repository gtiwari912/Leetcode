// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.minSum(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public static long minSum(int arr[], int n)
   {
       // Your code goes here
        
       Arrays.sort(arr);

       String s1="0";
       String s2="0";
   for(int i=0;i<n;i+=2) s1+=arr[i];
   for(int i=1;i<n;i+=2) s2+=arr[i];
   long a1=0;
   long a2=0;
   
    a1=Long.parseLong(s1);
   
    a2=Long.parseLong(s2);
   
   return a1+a2;
       
   }
}