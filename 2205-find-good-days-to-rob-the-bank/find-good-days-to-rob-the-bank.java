class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[]left = new int[n];
        // Arrays.fill(left,1);
        int[]right = new int[n];
        // Arrays.fill(right,1);
        for(int i=1;i<n;i++){
            if(security[i-1]>=security[i])left[i]=left[i-1]+1;
        }
        for(int i=n-2;i>=0;i--){
            if(security[i]<=security[i+1])right[i]=right[i+1]+1;
        }
        List<Integer>ds = new ArrayList<>();
        for(int i=time;i<=n-time && i<n;i++){
            if(left[i]>=time && right[i]>=time)ds.add(i);
        }
        return ds;
        
        
    }
}