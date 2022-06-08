class Solution {
    public int calculate(String s) {
        //splitting it into tokens and putting every token into array;
        ArrayList<String> list = new ArrayList<>();
        HashSet<Character> operators = new HashSet<>(){{
            add('*');
            add('/');
            add('-');
            add('+');
        }};
        StringBuilder sb  = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c==' ')
                continue;
            if(operators.contains(c)){
                list.add(sb.toString());
                list.add(""+c);
                sb = new StringBuilder();
            }
            else
                sb.append(c);
        }
        list.add(sb.toString());
        
        //solving multiplication;
        int start = 0;
        Stack<String> stack = new Stack<>();
        while(start<list.size()){
            String cur = list.get(start++);
            if(cur.equals("*")){
                String prev = stack.pop();
                String next = list.get(start++);
                stack.push("" +
                          (Integer.parseInt(prev) * Integer.parseInt(next))
                          );
            }
            else if(cur.equals("/")){
                String prev = stack.pop();
                String next = list.get(start++);
                stack.push("" +
                          (Integer.parseInt(prev) / Integer.parseInt(next))
                          );
            }
            else
                stack.push(cur);
        }
        
       // System.out.println(stack);
        //solving division;
        // list = new ArrayList<>();
        // for(String ele: stack)
        //     list.add(ele);
        // start = 0;
        // stack = new Stack();
        // while(start<list.size()){
        //     String cur = list.get(start++);
        //     if(cur.equals("/")){
        //         String prev = stack.pop();
        //         String next = list.get(start++);
        //         stack.push("" +
        //                   (Integer.parseInt(prev) / Integer.parseInt(next))
        //                   );
        //     }
        //     else
        //         stack.push(cur);
        // }
        
        //System.out.println(stack);
        //solving addition; and subtraction
        list = new ArrayList<>();
        for(String ele: stack)
            list.add(ele);
        start = 0;
        stack = new Stack();
                while(start<list.size()){
            String cur = list.get(start++);
            if(cur.equals("+")){
                String prev = stack.pop();
                String next = list.get(start++);
                stack.push("" +
                          (Integer.parseInt(prev) + Integer.parseInt(next))
                          );
            }
            else if(cur.equals("-")){
                String prev = stack.pop();
                String next = list.get(start++);
                stack.push("" +
                          (Integer.parseInt(prev) - Integer.parseInt(next))
                          );
            }
            else
                stack.push(cur);
        }
        
       // System.out.println(stack);
        //solving subtraction;
        // list = new ArrayList<>();
        // for(String ele: stack)
        //     list.add(ele);
        // start = 0;
        // stack = new Stack();
        //         while(start<list.size()){
        //     String cur = list.get(start++);
        //     if(cur.equals("-")){
        //         String prev = stack.pop();
        //         String next = list.get(start++);
        //         stack.push("" +
        //                   (Integer.parseInt(prev) - Integer.parseInt(next))
        //                   );
        //     }
        //     else
        //         stack.push(cur);
        // }
        //System.out.println(stack);
        
        
        return Integer.parseInt(stack.pop());
    }
    
    
}