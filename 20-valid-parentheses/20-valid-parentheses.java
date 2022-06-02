import java.util.*;

class Solution {
    // public static void main(String[] args) {
    //     System.out.println("hello world");
    //     System.out.println(isValid("()(()))()()()()(){}{}{{}{}{}}{{}{}{"))
    // }
    public boolean isValid(String s){
        ArrayList<Character> open = new ArrayList<>()
        {{
            add('(');
            add('[');
            add('{');
        }};
        ArrayList<Character> close = new ArrayList<>()
        {{
            add(')');
            add(']');
            add('}');
        }};

        Stack<Character> stack = new Stack<>();
        for(char cur : s.toCharArray()){
            if(open.contains(cur)){
                stack.add(cur);
            }
            else{
                if(stack.isEmpty())
                    return false;
                char popped = stack.pop();
                if(open.indexOf(popped) != close.indexOf(cur))
                {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }

}