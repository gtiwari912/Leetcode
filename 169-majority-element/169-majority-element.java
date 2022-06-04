class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = 0;
        int majorityCount = 0;
        for(int cur: nums){
            if(majorityCount==0)
                majorityElement = cur;
            if(cur == majorityElement){
                majorityCount++;
            }
            else{
                majorityCount--;
            }
        }
        
        return majorityElement;
    }
}