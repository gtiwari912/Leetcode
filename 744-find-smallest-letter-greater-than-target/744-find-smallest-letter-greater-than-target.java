class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            System.out.println("l:"+left+" r:"+right+" m:"+mid);
            if(letters[mid] == target){
                left = mid+1;
                // break;
            }
            else if(letters[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println("LEFT POSITON: "+left);
        if(left==letters.length)
            return letters[0];
        return letters[left];
    }
}