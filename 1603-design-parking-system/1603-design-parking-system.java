class ParkingSystem {
    int bigCap;
    int medCap;
    int smallCap;
    int big;
    int small;
    int med;
    public ParkingSystem(int big, int medium, int small) {
        bigCap = big;
        medCap = medium;
        smallCap = small;
        big = 0;
        small = 0;
        med = 0;
    }
    
    public boolean addCar(int carType) {
        if(carType==1){
            return big++<bigCap;
        }
        else if(carType==2){
            return med++<medCap;
        }
        else
            return small++<smallCap;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */