class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int cnt=0;
        for(int left =0;left<s.length();left++){
            HashMap<Character,Integer>map =new HashMap<>();
            int max = 0;
            for(int right=left;right<s.length();right++){
                map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
                 max = Math.max(max,map.get(s.charAt(right)));
                if(max>=k){
                    cnt+=(n-right);
                    break;
                }
            }
        }
        return cnt;
    }
}