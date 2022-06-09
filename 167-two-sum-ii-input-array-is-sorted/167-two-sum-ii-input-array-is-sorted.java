class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length -1;
        while(start<end){
            int num1 = numbers[start];
            int num2 = numbers[end];
            if(num1 + num2 == target){
                int[] ans = new int[2];
                ans[0] = start+1;
                ans[1] = end+1;
                return ans;
            }
            else if(num1 + num2 < target){
                start++;
            }
            else{
                end--;
            }
        }
        
        return new int[2];
    }
}