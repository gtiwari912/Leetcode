class Solution {
    HashSet<Character> row1;
    HashSet<Character> row2;
    HashSet<Character> row3;
    
    public String[] findWords(String[] words) {
        row1 = new HashSet<>();
        row2 = new HashSet<>();
        row3 = new HashSet<>();
        String row1Chars = "qwertyuiopQWERTYUIOP";
        String row2Chars = "asdfghjklASDFGHJKL";
        String row3Chars = "zxcvbnmZXCVBNM";
        
        String name = "Aakansha";
        for(char c: row1Chars.toCharArray()){
            row1.add(c);
        }
        for(char c: row2Chars.toCharArray()){
            row2.add(c);
        }
        for(char c: row3Chars.toCharArray()){
            row3.add(c);
        }
        
        List<String> ansList = new ArrayList<>();
        for(String curWord: words){
            if(helper(curWord)){
               ansList.add(curWord); 
            }
        }
        
        String[] ans = new String[ansList.size()];
        for(int i = 0; i<ans.length; i++){
            ans[i] = ansList.get(i);
        }
        
        return ans;
        
    }
    
    private boolean helper(String str){
        int[] arr = new int[3];
        
        for(char c: str.toCharArray()){
            if(row1.contains(c)){
                arr[0] = 1;
            }
            else if(row2.contains(c)){
                arr[1] = 1;
            }
            else if(row3.contains(c)){
                arr[2] = 1;
            }
        }
        
        // System.out.println(Arrays.toString(arr));
        
        int sum = 0;
        for(int arrayElement : arr){ 
            sum = sum + arrayElement;
        }
        
        return sum==1;
    }
}