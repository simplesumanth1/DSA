class Solution {
    static class Pair implements Comparable<Pair>{
        int startTime, endTime, profit;
        public Pair(int startTime,int endTime,int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;

        }
        public int compareTo(Pair o){
            return (this.startTime - o.startTime);
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
    public int f(Pair items[],int ind,int[]dp){
        if(ind>=items.length)return 0;
        if(dp[ind]!=-1)return dp[ind];
        int nextInd = lowerBound(items,ind+1,items[ind].endTime);
        int take = items[ind].profit;
        if(nextInd != -1)
        take = take+f(items,nextInd,dp);
        int notTake = f(items,ind+1,dp);
        return dp[ind]=Math.max(take,notTake);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Pair[]items = new Pair[n];
        for(int i=0;i<n;i++){
            items[i]=new Pair(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(items);
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(items,0,dp);

        
    }
}