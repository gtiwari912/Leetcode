class Solution {
    public String reversePrefix(String word, char ch) {
        int firstOccourence = word.indexOf(ch+"");
        if(firstOccourence == -1) return word;
        char[] arr = word.toCharArray();
        reverse(arr, 0, firstOccourence);
        String ans = new String(arr);
        return ans;
    }
    
    private void reverse(char[] arr, int start, int end){
        while(start<end){
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}



// String name = "Gaurav";
// int index = name.indexOf("uv");      -1
