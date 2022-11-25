class Solution {
    public String largestOddNumber(String num) {
        int lastIndex = -1;
        for(int i = num.length()-1; i>=0; i--){
            char curChar = num.charAt(i);
            int a = curChar -'0';
            if(a%2==1){
                lastIndex = i;
                break;
            }
        }
        
        String ans = num.substring(0, lastIndex+1);
        return ans;
    }
}