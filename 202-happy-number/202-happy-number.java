class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(true){
            if(set.contains(n))
                return false;
            List<Integer> list = new ArrayList<>();
            int tempN = n;
            while(n!=0){
                list.add(n%10);
                n /= 10;
            }
            int sum = 0;
            for(int cur: list)
                sum += cur*cur;
            if(sum == 1)
                return true;
            set.add(tempN);
            n = sum;
        }
        
        // return true;
    }
}