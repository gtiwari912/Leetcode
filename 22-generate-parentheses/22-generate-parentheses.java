class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        Stack<String> open = new Stack<>();
        recurse(open, n, new StringBuilder());
        return ans;
    }
    
    
    private void recurse(Stack<String> stack, int n, StringBuilder sb){
        if(n==0 && stack.isEmpty()){
            ans.add(sb.toString());
            return;
        }
        if(stack.isEmpty() && n>0){
            stack.push("(");
            sb.append("(");
            recurse(stack, n-1, sb);
            return;
        }
        if(n==0){
            while(!stack.isEmpty()){
                sb.append(")");
                stack.pop();
            }
            ans.add(sb.toString());
            return;
        }
        else{
            StringBuilder newSb = new StringBuilder(sb.toString());
            Stack<String> newStack = new Stack<>();
            newStack.addAll(stack);
            sb.append("(");
            stack.push("(");
            recurse(stack, n-1, sb);
            
            newStack.pop();
            newSb.append(")");
            recurse(newStack, n, newSb);
        }
    }
}