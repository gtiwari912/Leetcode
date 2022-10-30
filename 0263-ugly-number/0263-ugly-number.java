class Solution {
    public boolean isUgly(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        int[] arr = {2, 3, 5};
        while(n != 1){
            if(n%2 != 0 && n%3!=0 && n%5!=0) return false;
            if(n%2==0){
                n /= 2;
                continue;
            }
            if(n%3==0){
                n /= 3;
                continue;
            }
            if(n%5==0){
                n /= 5;
                continue;
            }
        }
        return true;
    }
}