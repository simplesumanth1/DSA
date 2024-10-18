class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        System.out.println(map);
        int[]res = new int[2];
        int ind=0;
        for(Map.Entry<Integer,Integer>m:map.entrySet()){
            if(m.getValue()==2)res[ind++]=m.getKey();
        }
        return res;
    }
}