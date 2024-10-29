class Solution {
    static class Pair implements Comparable<Pair>{
        int startTime,endTime,tip;
        public Pair(int startTime,int endTime,int tip){
            this.startTime = startTime;
            this.endTime = endTime;
            this.tip = tip;
        }
        public int compareTo(Pair o){
            return this.startTime - o.startTime;
        }
    }
     public int lowerBound(Pair[]items,int left,int target){
        int right = items.length-1;
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(items[mid].startTime >= target){
                ans = mid;
                right = mid-1;
            }else left = mid+1;
        }
        return ans;
    }
    public long f(Pair[]items,int ind,long[]dp){
        if(ind>=items.length)return 0;
        if(dp[ind]!=-1)return dp[ind];
        int nextInd = lowerBound(items,ind+1,items[ind].endTime);
        long take = (long)(items[ind].endTime - items[ind].startTime)+(long)(items[ind].tip);
        if(nextInd != -1){
            take = take+f(items,nextInd,dp);
        }
        long notTake = f(items,ind+1,dp);
        return dp[ind]=Math.max(take,notTake);
        
    }
    public long maxTaxiEarnings(int n1, int[][] rides) {
        int n  = rides.length;
        Pair[]items = new Pair[n];
        for(int i=0;i<n;i++){
            int[]row = rides[i];
            int startTime = row[0];
            int endTime = row[1];
            int tip = row[2];
            items[i]=new Pair(startTime,endTime,tip);
        }
        Arrays.sort(items);
        long[]dp = new long[n];
        Arrays.fill(dp,-1);
        return f(items,0,dp);
    }
}