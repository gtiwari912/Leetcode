class Solution {
    public int evalRPN(String[] tokens) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(String str: tokens){
            if(str.equals("+")){
                int one = stack.pop();
                int two = stack.pop();
                stack.add(one+two);
                // System.out.println("adding "+one+" and "+two);
            }
            else if(str.equals("-")){
                int one = stack.pop();
                int two = stack.pop();
                stack.add(two-one);
                // System.out.println("Subtracting "+one+" and "+two);
            }
            else if(str.equals("/")){
                int one = stack.pop();
                int two = stack.pop();
                stack.add(two/one);
                // System.out.println("Dividing "+one+" and "+two);
            }
            else if(str.equals("*")){
                int one = stack.pop();
                int two = stack.pop();
                stack.add(one*two);
                // System.out.println("Multiplying "+one+" and "+two);
            }
            else{
                int num = Integer.parseInt(str);
                stack.add(num);
            }
        }
        System.out.println(stack);
        return stack.pop();
    }
}