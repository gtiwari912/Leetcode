class Solution {
    public int[] sumZero(int n) {
        if(n==1) return new int[1];
        int a = -1;
        int arr[] = new int[n];
        // if(n%2==0){
            for(int i = 0; i<n; i++){
                if(i%2==0) arr[i] = a;
                else arr[i] = Math.abs(a);
                if(i%2==1) a--;
            }
        if(n%2==1){
            arr[n-2] = arr[n-2] + Math.abs(arr[n-1]);
        
        }
        return arr;
        // }
    }
}