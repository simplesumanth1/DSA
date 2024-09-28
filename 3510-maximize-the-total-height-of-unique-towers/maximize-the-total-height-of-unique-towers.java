class Solution {
    public long maximumTotalSum(int[] nums) {
        int n = nums.length;
        Integer[]maximumHeight = new Integer[n];
        for(int i=0;i<n;i++)maximumHeight[i]=nums[i];
        Arrays.sort(maximumHeight,Collections.reverseOrder());
        Set<Integer>set = new  HashSet<>();
        long sum=maximumHeight[0];
        
        for(int i=1;i<n;i++){
            maximumHeight[i]=Math.min(maximumHeight[i],maximumHeight[i-1]-1);
            if(maximumHeight[i]==0) return -1;
            sum+=maximumHeight[i];


        }
        return sum;
        
    }
}