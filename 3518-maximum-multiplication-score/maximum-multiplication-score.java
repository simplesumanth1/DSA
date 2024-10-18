class Solution {
    public long f(int ind,int ai,int[]a,int[]b,Long[][]dp){
        if(ai<0)return 0;
        if(ind<ai)return Long.MIN_VALUE;
        if(dp[ind][ai]!=Long.MIN_VALUE)return dp[ind][ai];
        long notTake = f(ind-1,ai,a,b,dp);
        long take = (long)(a[ai])*(long)(b[ind])+ f(ind-1,ai-1,a,b,dp);
        return dp[ind][ai]= Math.max(notTake,take);
    }
    public long maxScore(int[] a, int[] b) {
        int n = b.length;
        Long[][]dp = new Long[n][4];
        for(Long[]row:dp)Arrays.fill(row,Long.MIN_VALUE);
        return f(n-1,3,a,b,dp);
        
    }
}