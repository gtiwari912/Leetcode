class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            int ele = nums[i];
            map.put((long)ele, map.getOrDefault((long)ele, 0)+1);
            // if(map.containsKey(ele)){
            //     map.get((long)ele).add(i);
            // }
            // else{
            //     map.put((long)ele, new ArrayList<Integer>());
            //     map.get((long)ele).add(i);
            // }
        }
        HashSet<List<Integer>> ansset = new HashSet<>();
        for(int i= 0; i<n; i++){
            int eleOne = nums[i];
            for(int j=i+1; j<n; j++){
                if(i==j)
                    continue;
                int eleTwo = nums[j];
                for(int k = j+1; k<n; k++){
                    if(k==i || k==j)
                        continue;
                    int eleThree = nums[k];
                    long req = ((long)target - 
                        (long)((long)eleOne + (long)eleTwo + (long)eleThree));
                    if(!map.containsKey(req))
                        continue;
                    else{
                        if(req==eleOne && req==eleTwo && req==eleThree){
                            if(map.get(req)>3){
                                List<Integer> list = new ArrayList<>();
                                list.add(eleOne);
                                list.add(eleTwo);
                                list.add(eleThree);
                                list.add((int)req);
                                Collections.sort(list);
                                ansset.add(list);
                            }
                        }
                        else if((req==eleOne && req==eleTwo) ||
                                    (req==eleTwo && req==eleThree) ||
                                    (req==eleOne && req==eleThree)
                               ){
                            if(map.get(req)>2){
                                List<Integer> list = new ArrayList<>();
                                list.add(eleOne);
                                list.add(eleTwo);
                                list.add(eleThree);
                                list.add((int)req);
                                Collections.sort(list);
                                ansset.add(list);
                            }
                        }
                        else if(req==eleOne || req==eleTwo || req==eleThree){
                            if(map.get(req)>1){
                                List<Integer> list = new ArrayList<>();
                                list.add(eleOne);
                                list.add(eleTwo);
                                list.add(eleThree);
                                list.add((int)req);
                                Collections.sort(list);
                                ansset.add(list);
                            }
                        }
                        else{
                            List<Integer> list = new ArrayList<>();
                                list.add(eleOne);
                                list.add(eleTwo);
                                list.add(eleThree);
                                list.add((int)req);
                                Collections.sort(list);
                                ansset.add(list);
                        }
                    }
                }
            }
        }
        
        
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> cur: ansset){
            ans.add(cur);
        }
        
        return ans;
    }
}

// List<Integer> list = new ArrayList<>();
//                                 list.add(eleOne);
//                                 list.add(eleTwo);
//                                 list.add(eleThree);
//                                 list.add((int)req);
//                                 Collections.sort(list);
//                                 ansset.add(list);
//                                 break;