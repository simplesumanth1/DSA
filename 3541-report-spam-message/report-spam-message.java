class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashMap<String,Integer>map = new HashMap<>();
        Set<String>set = new HashSet<>();
        for(String ele:bannedWords)set.add(ele);
        for(String ele:message)map.put(ele,map.getOrDefault(ele,0)+1);
        int cnt=0;
        for(String ele:set){
            if(map.containsKey(ele))cnt+=map.get(ele);
            if(cnt>=2)return true;
        }
        return cnt>=2?true:false;
    }
}