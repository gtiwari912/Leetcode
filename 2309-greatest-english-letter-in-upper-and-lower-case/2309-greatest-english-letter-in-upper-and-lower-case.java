class Solution {
    public String greatestLetter(String s) {
        HashSet<Integer> upperSet = new HashSet<>();
        HashSet<Integer> lowerSet = new HashSet<>();
        for(char c: s.toCharArray()){
            if(c>='a' && c<='z') // c is lowercase
                lowerSet.add(c-'a');
            else // c is uppercase
                upperSet.add(c-'A');
        }
        
        int max = -1;
		int TOTAL_ALPHABETS = 26;
        for(int i = 0; i < TOTAL_ALPHABETS; i++){
            if(upperSet.contains(i) && lowerSet.contains(i))
                max = i;
        }
		
        if(max==-1)
            return "";
			
        char ansChar = (char)((int)'A'+max);
        return ""+ansChar;
    }
}