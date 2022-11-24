class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.indexOf(part) != -1){
            int index = s.indexOf(part);
            String newStr = s.substring(0, index) + s.substring(index+part.length());
            s = newStr;
        }
        
        return s;
        
        
    }
}

// index = 3
//       i
// a a b b c a a
// 0 1 2 3 4 5 6  
    
    
//     i + part.length() = 3+2 = 5