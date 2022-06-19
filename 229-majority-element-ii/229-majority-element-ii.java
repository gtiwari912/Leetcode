class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 1;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int cur: nums){
            if(cur == num1) count1++;
            else if(cur == num2) count2++;
            else if(count1==0){
                num1 = cur;
                count1++;
            }
            else if(count2==0){
                num2 = cur;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        int num1Count = 0;
        int num2Count = 0;
        for(int cur: nums){
            if(cur==num1)
                num1Count++;
            else if(cur==num2)
                num2Count++;
        }
        if(num1Count>nums.length/3)
            ans.add(num1);
        if(num2Count>nums.length/3)
            ans.add(num2);
        return ans;
    }
}