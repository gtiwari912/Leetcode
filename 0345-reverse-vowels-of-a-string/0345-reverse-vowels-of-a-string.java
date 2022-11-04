class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>(){{
            add('a');
            add('A');
            add('e');
            add('E');
            add('i');
            add('I');
            add('o');
            add('O');
            add('u');
            add('U');
        }};
        List<Character> list = new ArrayList<>();
        for(char c: s.toCharArray()) if(set.contains(c)) list.add(c);
        Collections.reverse(list);
        int iter=0;
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(set.contains(c)){
                sb.append(list.get(iter++));
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}