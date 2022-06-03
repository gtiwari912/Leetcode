class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int counter = 0;
        int n = nums.length;
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, 1);
        int[] prefixSum = new int[n];
        int sum = 0;
        for(int i = 0; i<n; i++){
            int cur = nums[i];
            sum += cur;
            int curRemainder = sum % k;
            if(curRemainder<0) 
                curRemainder += k;
            if(seen.containsKey(curRemainder)){
                counter += seen.get(curRemainder);
                seen.put(curRemainder, seen.get(curRemainder)+1);
            }
            else{
                seen.put(curRemainder, 1);
            }
        }
        
        
        return counter;
    }
}