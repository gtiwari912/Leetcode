class Solution {
    public int countPoints(String rings) {
        int[] arr = new int[10];
        HashSet<Character>[] setArr = new HashSet[10];
        for(int i = 0; i<10; i++){
            setArr[i] = new HashSet<Character>();
        }
        
        for(int i = 0; i<rings.length(); i+=2){
            char c1 = rings.charAt(i);
            char c2= rings.charAt(i+1);
            int index = c2-'0';
            setArr[index].add(c1);
        }
        
        int count = 0;
        for(HashSet<Character> curSet: setArr)
            if(curSet.size()==3) count++;
        return count;
    }
}

// 'M' -'A'
    


