class Solution {
    public String largestOddNumber(String num) {
        int lastIndex = -1;
        for(int i = num.length()-1; i>=0; i--){
            char curChar = num.charAt(i);
            if(curChar =='1' || curChar=='3' || curChar=='5' || curChar=='7' || curChar=='9'){
                lastIndex = i;
                break;
            }
        }
        
        String ans = num.substring(0, lastIndex+1);
        return ans;
    }
}