class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.indexOf(part) != -1){
            int index = s.indexOf(part);
            String newStr = s.substring(0,index)+s.substring(index+part.length());
            s = newStr;
        }
        return s;
    }
}