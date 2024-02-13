class Solution {
    public int singleNumber(int[] nums) {
        int curNum = 0;
        int count = 0;
        for(int i =0 ; i<nums.length; i++){
            curNum = nums[i];
            for(int j = 0; j<nums.length; j++){
                if(nums[j] == curNum) {
                    count++;
                }
            }
            if(count == 1) return curNum;
            count = 0;
        }
        
        return 0;
    }
}

// [1,4,2,1,2]
// curNum  = 4
//    count = 0 
// 2 variables
// 2 for loop