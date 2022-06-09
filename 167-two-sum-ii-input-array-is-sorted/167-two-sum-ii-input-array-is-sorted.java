class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i<numbers.length; i++){
            int curNum = numbers[i];
            int req = target-curNum;
            int secondIndex = binSearch(numbers, req);
            if(secondIndex != -1 && secondIndex != i+1){
                int[] ans = new int[2];
                ans[0] = i+1;
                ans[1] = secondIndex;
                Arrays.sort(ans);
                return ans;
            }
        }
        
        return new int[2];
    }
    
    private int binSearch(int[] arr, int target){
        int start = 0;
        int end = arr.length -1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==target)
                return mid+1;
            if(arr[mid]<target){
                start = mid+1;
            }
            else
                end = mid-1;
        }
        return -1;
    }
}