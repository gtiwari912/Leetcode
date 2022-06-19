// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 


class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt(); 
            int arr[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int []ans= obj.sortArr(arr, n);
            for(int i=0;i<n;i++)
            {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
        
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int[] sortArr(int[] arr, int n) 
    { 
        // code here
        sort(arr);
        return arr;
    }
    
    private void sort(int[] arr){
        if(arr.length<2)
            return;
        int mid = arr.length/2;
        int[] left = new int[mid];
        for(int i = 0; i<mid; i++)
            left[i] = arr[i];
        int[] right = new int[arr.length - mid];
        for(int i = mid; i<arr.length; i++)
            right[i-mid] = arr[i];
        sort(left);
        sort(right);
        merge(arr, left, right);
        return;
        
    }
    
    private void merge(int[] ans, int[] arr1, int[] arr2){
        int m = arr1.length;
        int n = arr2.length;
        int start1 = 0;
        int start2 = 0;
        int iter = 0;
        while(start1<m && start2<n){
            int a = arr1[start1];
            int b = arr2[start2];
            if(a<b){
                ans[iter++] = a;
                start1++;
            }
            else{
                ans[iter++] = b;
                start2++;
            }
        }
        
        while(start1<m){
            ans[iter++] = arr1[start1++];
        }
        while(start2<n){
            ans[iter++] = arr2[start2++];
        }
    }
} 