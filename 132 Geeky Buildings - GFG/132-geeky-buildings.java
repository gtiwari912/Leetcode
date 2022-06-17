// { Driver Code Starts
//Initial template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]= new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            if(ob.recreationalSpot(arr,n))
                System.out.println("True");
            else
                System.out.println("False");
        }
	}
}// } Driver Code Ends


//User function template for C++

class Solution{
   static int max=Integer.MIN_VALUE;
   static boolean recreationalSpot(int[] nums , int n){
       return find(nums,0);
   }
   public static boolean find(int[] nums,int n) {
       if(nums.length-n<3) return false;
       if(call(nums,n)){
           return true;
       }
       max=Math.max(max,nums[n]);
       while(nums.length-n>=3){
           if(nums[n+1]>max){
               n++;
           }
           else if(find(nums,++n)){
               return true;
           }
       }
       return false;
   }
   public static boolean call(int[] nums,int n){
       int i=nums[n];
       int j=nums[++n];
       while(n<nums.length-1){
           if(i>j){
               j=nums[++n];
           }
           if(n<nums.length-1 && i<j && i<nums[n+1]){
               if(nums[n+1]<j){
                   return true;
               }
               else{
                   j=nums[++n];
               }
           }
           else if(n<nums.length-1){
               n++;
           }
       }
       return false;
   }
}