class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        char[] stonesWeHave = stones.toCharArray();
        char[] jwels = jewels.toCharArray();
        //jwels:  ['a','A']
        // ['a','A','A','b',....]
                         // ^
        int count = 0;
        for(char curElement: stonesWeHave){
            for(char elementOfJwel: jwels){
                if(curElement == elementOfJwel){
                    count++;
                    continue;
                }
            }
        }
        
        return count;
        
        
        
    }
}
                  
// stones : aAAbbbb
// jewels: aA
            // .




