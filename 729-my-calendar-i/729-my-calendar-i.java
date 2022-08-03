class MyCalendar {
    ArrayList<int[]> bookings;
    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] zone: bookings){
            // System.out.println("Comparing s:"+start+" e:"+end+" with "+Arrays.toString(zone));
            if(start<zone[1] && end>zone[0]) {
                // int[] newArr = {start, end};
                // bookings.add(newArr);
                return false;
            }
        }
        int[] newArr = {start, end};
        bookings.add(newArr);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */