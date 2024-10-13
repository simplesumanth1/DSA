class Solution {
    static class Pair implements Comparable<Pair>{
        int ele,freq;
        public Pair(int ele,int freq){
            this.ele = ele;
            this.freq = freq;
        }
        public int compareTo(Pair o){
            if(this.freq!=o.freq){
                return (this.freq - o.freq);
            }
            return (this.ele - o.ele);
        }
    }
    public int calculateSum(HashMap<Integer,Integer>map,int x){
        if(map.size()<x){
            int sum=0;
            for(Map.Entry<Integer,Integer>m:map.entrySet()){
                sum+=(m.getKey()*m.getValue());
            }
            return sum;
        }
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        int sum=0;
        for(Map.Entry<Integer,Integer>m:map.entrySet()){
            pq.offer(new Pair(m.getKey(),m.getValue()));
            if(pq.size()>x)pq.poll();
        }
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            sum+=(top.ele*top.freq);
        }
        return sum;
    }
    public int[] findXSum(int[] nums, int k, int x) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int n = nums.length;
        int[]ans = new int[n-k+1];
        int sum = calculateSum(map,x);
        int ind=0;
        ans[ind]=sum;
        for(int i=1;i<=n-k;i++){
            int prevFreq = map.get(nums[i-1]);
            if(prevFreq == 1)map.remove(nums[i-1]);
            else map.put(nums[i-1],prevFreq-1);
            map.put(nums[i+k-1],map.getOrDefault(nums[i+k-1],0)+1);
            int xsum = calculateSum(map,x);
            ind++;
            ans[ind]=xsum;
        }
        return ans;
        
    }
}