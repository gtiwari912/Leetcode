class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        int[][] arr = new int[26][n];
        for(int i = 0; i<n; i++){
            String word = words[i];
            for(char c: word.toCharArray()){
                int index = c-'a';
                int index2 = i;
                arr[index][index2]++;
            }
        }
        List<String> ans = new ArrayList<>();
        char nowChar = 'a';
        for(int[] ar : arr){
            int max = max(ar);
            for(int i = 0; i<max; i++) ans.add(nowChar+"");
            nowChar++;
        }
        return ans;
    }
    
    
    private int max(int[] arr){
        int max = arr[0];
        for(int i: arr) max = Math.min(i, max);
        return max;
    }
}