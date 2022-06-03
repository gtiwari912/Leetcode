class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> ansSet = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int cur: nums){
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }
        for(int i = 0; i<n; i++){
            int firstNum = nums[i];
            for(int j = i+1; j<n; j++){
                int secondNum = nums[j];
                int req = 0 - firstNum - secondNum;
                if(map.containsKey(req)){
                    if(firstNum != req && secondNum != req){
                        List<Integer> now = new ArrayList<>()
                        {{
                            add(firstNum);
                            add(secondNum);
                            add(req);
                        }};
                        Collections.sort(now);
                        ansSet.add(now);
                    }
                    else if(firstNum==secondNum && req==firstNum){
                        if(map.get(req)>2){
                            List<Integer> now = new ArrayList<>()
                            {{
                                add(firstNum);
                                add(secondNum);
                                add(req);
                            }};
                            Collections.sort(now);
                            ansSet.add(now);
                        }
                    }
                    else{
                        if(map.get(req)>1){
                            List<Integer> now = new ArrayList<>()
                            {{
                                add(firstNum);
                                add(secondNum);
                                add(req);
                            }};
                            Collections.sort(now);
                            ansSet.add(now);
                        }
                    }
                }
            }
        }
        for(List<Integer> na: ansSet)
            ans.add(na);
        return ans;
    }
}