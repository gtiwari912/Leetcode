class Solution {
    public String reformatDate(String date) {
        int dt = 0;
        int month = 0;
        int year = 0;
        StringBuilder dtSb = new StringBuilder();
        for(char c: date.toCharArray()){
            if(c>='a' && c<='z') break;
            dtSb.append(c);
        }
        dt = Integer.parseInt(dtSb.toString());
        
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for(int i = 0; i<months.length; i++){
            String curMonth = months[i];
            if(date.indexOf(curMonth) != -1){
                month = i+1;
                break;
            }
        }
        
        StringBuilder yearSb = new StringBuilder();
        for(int i = date.length()-4; i<date.length(); i++){
            yearSb.append(date.charAt(i));
        }
        
        year = Integer.parseInt(yearSb.toString());
        
        String monthString = (month<10)? "0"+month : ""+month;
        String dtString = (dt<10)? "0"+dt : ""+dt;
        
        String ans = year + "-" + monthString + "-" + dtString;
        return ans;
        
    }
}


// Integer.parseInt("11",2) -> 3
// {a, p, p, l, e}.toString()
// "28"
// date        ->
// month       -> got it
// year        -> Last 4 Characters

// {
// Jan-1
// Feb-2
// Mar-3
// Apr-4
// }