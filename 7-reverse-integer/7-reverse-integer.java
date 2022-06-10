class Solution {
    public int reverse(int x) {
        boolean isNeg = x<0;
        int reversed = 0;
        while(x!=0){
            int tail = x%10;
            int ogReversed = reversed;
            reversed = reversed*10 + tail;
            if((reversed-tail)/10 != ogReversed)
                return 0;
            x /= 10;
        }
        
        return reversed;
        // return isNeg? -reversed:reversed;
    }
}