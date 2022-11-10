class Solution {
    public String removeDuplicates(String s) {
        
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length() - 1; i++) {

            if (sb.charAt(i) == sb.charAt(i+1)) {
                sb.deleteCharAt(i+1);
                sb.deleteCharAt(i);
                if (i >= 1) {
                    i -= 2;
                } else if (i == 0) {
                    i--;
                }
            }
        }

        String result = sb.toString();

        return result;

    }
}