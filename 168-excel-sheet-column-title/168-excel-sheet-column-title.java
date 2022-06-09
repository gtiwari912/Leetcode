class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        // n--;
        while(n!=0){
            n--;
            char c = (char)('A'+ n%26) ;
            sb.append(c);
            n /= 26;
        }
        // System.out.println(sb);
        return sb.reverse().toString();
    }
}