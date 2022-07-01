class Solution {
    public double myPow(double x, int n) {
        return pow(x, n);
    }
    
    public double pow(double x, long m){
                // long m = n;
        if(x==0 || x==1 || m==1)
            return x;
        if(m==0)
            return 1;
        if(m<0){
            return 1/pow(x, m*(-1));
        }
        double half = pow(x, m/2);
        if(m%2==0){
            // return pow(x*x, m/2);
            return half * half;
        }
        else{
            // return pow(x*x, m/2)*x;
            return half * half * x;
        }
    }
}