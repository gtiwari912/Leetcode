class Solution {
    public String sortSentence(String s) {
        String[] inputS = s.split(" ");
        Arrays.sort(inputS, (a,b) -> 
                    (
                    Integer.parseInt(""+a.charAt(a.length()-1))
                        - Integer.parseInt(""+b.charAt(b.length()-1))
                    )
                   );
        StringBuilder sb = new StringBuilder();
        for(String cur: inputS){
            sb.append(cur.substring(0, cur.length()-1));
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
}