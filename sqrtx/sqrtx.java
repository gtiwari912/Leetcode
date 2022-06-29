class Solution {

    public int mySqrt(int x) {
        double low = 0d;
        double high = x;
        double mid = 0;
        while(low<=high){
            mid = low + (high- low)/2;
            double midSquare = mid * mid;
            int ans = almostSame(midSquare, x);
            if(ans != -1){
                if(almostSame(mid, (int)mid+1) != -1){
                    return (int)mid+1;
                }
                return (int) mid;
            }
            if(midSquare>x)
                high = mid;
            else
                low = mid;
        }        
        System.out.println(mid);
        return 1;
    }
    
    
    private int almostSame(double a, int b){
        double dif = Math.abs((double)b - a);
        if(dif<0.000001d)
            return b;
        return -1;
    }
}