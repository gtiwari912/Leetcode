class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String str = "123456789";
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<str.length(); i++){
            for(int j = i+1; j<=str.length();j++){
                list.add(getNum(str.substring(i,j)));
            }
        }
        Collections.sort(list);
        List<Integer> ans = new ArrayList<>();
        for(int i: list){
            if(i>=low && i<=high) ans.add(i);
        }
        return ans;
    }
    
    public int getNum(String str){
        if(str.length()==0) return -1;
        return Integer.parseInt(str);
    }
}