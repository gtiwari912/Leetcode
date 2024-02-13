class Solution {
    public String firstPalindrome(String[] words) {
        System.gc();
        for(String word: words) if(isPal(word)) return word;
        return "";
    }
    
    public boolean isPal(String str){
        return new StringBuilder(str).reverse().toString().equals(str);
    }
}