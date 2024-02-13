class Solution {
    public String firstPalindrome(String[] words) {
        for(String word: words) if(isPal(word)) return word;
        return "";
    }
    
    public boolean isPal(String str){
        return new StringBuilder(str).reverse().toString().equals(str);
    }
}