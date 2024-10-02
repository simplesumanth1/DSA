class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long  res=0;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int num:hours){
            int complement = (24-num%24)%24;
            if(map.containsKey(complement)){
                res+=map.get(complement);

            }
            map.put(num%24,map.getOrDefault(num%24,0)+1);
        }
        return res;
    }
}