class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000000+7;
        long count = 0;
        int noOfDaysActive = forget - delay;
        int noOfDaysInactive = delay;
        long[] active = new long[noOfDaysActive];
        long[] inactive = new long[noOfDaysInactive];
        inactive[0] = 1; //On first day only 1 person knows secret.
        for(int i = 0; i<n-1; i++){
		
            for(int j = noOfDaysActive-1; j>0; j--){
                active[j] = active[j-1];
            }
            active[0] = inactive[noOfDaysInactive-1];
			
			long newcomers = 0l;
            for(long newc: active){
                newcomers = (newcomers+newc)%mod; //doing mod to avoid overflow
            }
            for(int j= noOfDaysInactive-1; j>0; j--){
                inactive[j] = inactive[j-1];
            }
            inactive[0] = newcomers;
        }
        
        for(long k: inactive){
            count = count + k;
        }
        for(long k: active){
            count = count + k;
        }

        
        int ans = (int)(count % mod);
        return ans;

    }
}