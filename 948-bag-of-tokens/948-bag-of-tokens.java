class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int count = 0;
        int left = 0;
        int right = tokens.length - 1;
        int max = 0;
        while(left<=right){
            if(power>=tokens[left]){
                power -= tokens[left];
                left++;
                count++;
                max = Math.max(max, count);
            }
            else{
                if(count<=0) break;
                count--;
                power += tokens[right];
                right--;
            }
        }
        
        return max;
    }
    // [55, 71, 82]   power = 81 count = 0
         // lr
}