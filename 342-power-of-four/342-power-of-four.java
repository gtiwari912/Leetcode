class Solution {
    public boolean isPowerOfFour(int p) {
        double n = p;
        if(n==1)
            return true;
        while(n>0){
            if(n==4)
                return true;
            n /= 4;
        }
        
        return false;
    }
}