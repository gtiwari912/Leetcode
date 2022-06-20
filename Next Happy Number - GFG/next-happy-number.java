// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{

   static int nextHappy(int N){
       // code here
       for(int i=N+1; ; i++){
           if(isHappy(i)==true) return i;
       }
     //  return -1;
   }
    public static boolean isHappy(int n) {
       if(n==1){
           return true;
       }
       HashSet<Integer> set= new HashSet<>();
       int sum=0;
       while(n!=1){
           sum=0;
           while(n>0){
               int d=n%10;
               sum+=d*d;
               n=n/10;
           }             
           n=sum;
           if(!set.contains(n)){
               set.add(n);
           }
           else{
               return false;
           }
           if(sum==1) return true;
       }
       return false;   
   }
}