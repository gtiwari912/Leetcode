class Solution {
    public int thirdMax(int nums[]) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i<nums.length; i++){
            int curElement = nums[i];
            
            if(curElement > max){
                max = curElement;
            }
            
            set.add(curElement);
        }
        
        if(set.size() < 3)
            return max;
        
        int[] newArr = new int[set.size()];
        int index = 0;
        for(int elementFromSet : set){
            newArr[index] = elementFromSet;
            index++;
        }
        
        
        Arrays.sort(newArr);
        int lastIndex = newArr.length - 1;
        return newArr[lastIndex -2];
        
    }
}
   
   
// h(1) -> adxa532a
// h(2) -> adc32542
// h(123) -> afca524

// h(123) -> afca524

// hashset 
// 1. UNIQUE VALUES;
// 2. LOOKUP




// 0            9748927389472897
//     123 % 974892738947289735646346534654363463456345353453 = 123
//     6456 %9748927389472897 = 6456
    

