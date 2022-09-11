class Solution {
    public int minGroups(int[][] arr) {
        int[] prefix = new int[1000002];
        for(int[] a: arr){
            prefix[a[0]]++;
            prefix[a[1] + 1]--;
        }
        
        int sum = 0;
        for(int i = 0; i<prefix.length; i++){
            sum += prefix[i];
            prefix[i] = sum;
        }
        
        int max = 0;
        for(int i : prefix) max = Math.max(max, i);
        
        return max;
    }
}