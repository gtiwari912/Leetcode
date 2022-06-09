class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        System.out.println("a is "+a);
        System.out.println("b is "+b);
        StringBuilder sb  = new StringBuilder();
        int ptr1 = a.length() - 1;
        int ptr2 = b.length() - 1;
        int carry = 0;
        while(ptr1>=0 && ptr2>=0){
            int one = a.charAt(ptr1) - '0';
            int two = b.charAt(ptr2) - '0';
            if(one + two + carry == 0){
                sb.append(0);
            }
            else if(one + two + carry == 1){
                sb.append(1);
                carry = 0;
            }
            else if(one + two + carry == 2){
                sb.append(0);
                carry = 1;
            }
            else{
                sb.append(1);
                carry = 1;
            }
            ptr1--;
            ptr2--;
        }
        while(ptr1>=0){
            int one = a.charAt(ptr1) - '0';
            if(one+carry == 0){
                sb.append(0);
                carry = 0;
            }
            else if(one+carry == 1){
                sb.append(1);
                carry = 0;
            }
            else{
                sb.append(0);
                carry = 1;
            }
            ptr1--;
        }
        
        if(carry == 1)
            sb.append(carry); 
        
        return sb.reverse().toString();
    }
}