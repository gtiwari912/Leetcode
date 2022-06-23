class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int leftHighest = 0;
        for(int i = 0; i<n; i++){
            left[i] = leftHighest;
            leftHighest = Math.max(leftHighest, arr[i]);
        }
        
        int rightHighest = 0;
        for(int i = n-1; i>=0; i--){
            right[i] = rightHighest;
            rightHighest = Math.max(rightHighest, arr[i]);
        }
        
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans += Math.max(
                0,
                Math.min(left[i], right[i]) - arr[i]
            );
        }
        
        
        return ans;
    }
}