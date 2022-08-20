class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] scanLine = new int[n+1];
        for(int[] shift : shifts){
            if(shift[2] == 1){
                scanLine[shift[0]]++;
                scanLine[shift[1]+1]--;
            }
            else{
                scanLine[shift[0]]--;
                scanLine[shift[1]+1]++;
            }
        }
        
        for(int i = 1; i<scanLine.length; i++){
            scanLine[i] = scanLine[i-1]+scanLine[i];
        }
        
        char[] arr = s.toCharArray();
        for(int i = 0; i<arr.length; i++){
            int inc = (s.charAt(i) - 'a' + scanLine[i])%26;
            inc = (inc+26)%26;
            arr[i] = (char) ('a'+inc);
        }
        return new String(arr);
    }
}