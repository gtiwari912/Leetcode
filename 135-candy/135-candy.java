class Solution {
    public int candy(int[] ratings) {
        int size = ratings.length;
        int[] candies = new int[size];
        Arrays.fill(candies , 1);
        for(int i = 1; i<size; i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        
        for(int i = size-1; i>0; i--){
            if(ratings[i-1]>ratings[i]){
                candies[i-1] = Math.max(candies[i-1], candies[i]+1);
            }
        }
        
        int count = 0;
        for(int c: candies)
            count += c;
        return count;
    }
}