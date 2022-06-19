class Solution {
    public String greatestLetter(String s) {
        HashSet<Integer> upperSet = new HashSet<>();
        HashSet<Integer> lowerSet = new HashSet<>();
        for(char c: s.toCharArray()){
            if(c>='a' && c<='z')
                lowerSet.add(c-'a');
            else
                upperSet.add(c-'A');
        }
        
        int max = -1;
        for(int i = 0; i<26; i++){
            if(upperSet.contains(i) && lowerSet.contains(i))
                max = i;
        }
        
        if(max==-1)
            return "";
        char ansChar = (char)((int)'A'+max);
        return ""+ansChar;
    }
}