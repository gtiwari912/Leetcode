class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        char previous = '.';
        for(char c: s.toCharArray()){
            if(c==' ' && previous==' ')
                continue;
            else{
                sb.append(c);
                previous = c;
            }
        }
        String str = sb.toString().trim();
        String[] words = str.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i = words.length-1; i>=0; i--){
            ans.append(words[i]+" ");
        }
        
        return ans.toString().trim();
    }
}