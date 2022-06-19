class Solution {
    public int reversePairs(int[] nums) {
        long ans = sort(nums);
        return (int)ans;
    }
    
    private static long sort(int[] arr){
        long ans = 0l;
        if(arr.length<2)
            return 0l;
        int mid = arr.length/2;
        int[] left = new int[mid];
        for(int i = 0; i<mid; i++)
            left[i] = arr[i];
        int[] right = new int[arr.length - mid];
        for(int i = mid; i<arr.length; i++)
            right[i-mid] = arr[i];
        ans += sort(left);
        ans += sort(right);
        ans += merge(arr, left, right);
        return ans;
        
    }
    
    private static long merge(int[] ans, int[] arr1, int[] arr2){
        long res = 0l;
        int m = arr1.length;
        int n = arr2.length;
        int s1 = 0;
        int s2 = 0;
        for(s1=0; s1<m; s1++){
            int s1Ele = arr1[s1];
            while(s2<n && (long)arr2[s2]*(long)2<(long)s1Ele){
                s2++;
            }
            res += s2;
        }
        int start1 = 0;
        int start2 = 0;
        int iter = 0;
        while(start1<m && start2<n){
            int a = arr1[start1];
            int b = arr2[start2];
            if(a<=b){
                ans[iter++] = a;
                start1++;
            }
            else{
                ans[iter++] = b;
                start2++;
                // if(2*b<a)
                //     res += (m-start1);
            }
        }
        
        while(start1<m){
            ans[iter++] = arr1[start1++];
        }
        while(start2<n){
            ans[iter++] = arr2[start2++];
//             res++;
        }
        
        return res;
    }
}