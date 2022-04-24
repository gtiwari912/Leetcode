class UndergroundSystem {
    HashMap<Integer, Check> checkIns;
    HashMap<Integer, Check> checkOuts;
    HashMap<String, ArrayList<Integer>> stationTime;
    public UndergroundSystem() {
        checkIns = new HashMap<>();
        checkOuts = new HashMap<>();
        stationTime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Check check = new Check(id, stationName, t);
        checkIns.put(id, check);
    }
    
    public void checkOut(int id, String stationName, int t) {
        int startTime = checkIns.get(id).t;
        String startStation = checkIns.get(id).stationName;
        int timeTaken = t - startTime;
        if(!stationTime.containsKey(startStation+","+stationName)){
            stationTime.put(startStation+","+stationName, new ArrayList<>());
            stationTime.get(startStation+","+stationName).add(timeTaken);
        }
        else{
            stationTime.get(startStation+","+stationName).add(timeTaken);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double sum = 0;
        double count = 0;
        for(int cur: stationTime.get(startStation+","+endStation)){
            sum += cur;
            count += 1;
        }
        
        return sum/count;
    }
}

class Check{
    int id;
    String stationName;
    int t;
    Check(int id, String s, int t){
        this.id = id;
        stationName = s;
        this.t = t;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */