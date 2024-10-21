class Solution {
    public void f(int i,String s,int cnt,int[]maxCnt,Set<String>set){
        if(i==s.length()){
            maxCnt[0]=Math.max(maxCnt[0],cnt);
            return;
        }
        for(int j=i;j<s.length();j++){
            String substring = s.substring(i,j+1);
            if(!set.contains(substring)){
                set.add(substring);
                f(j+1,s,cnt+1,maxCnt,set);
                set.remove(substring);
            }
        }
    }
    public int maxUniqueSplit(String s) {
        int[]maxCnt = new int[1];
        f(0,s,0,maxCnt,new HashSet<>());
        return maxCnt[0];
    }
}