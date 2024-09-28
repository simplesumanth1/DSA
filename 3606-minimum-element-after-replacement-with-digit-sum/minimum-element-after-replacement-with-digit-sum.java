class Solution {
    public int sum(int ele){
        String s = String.valueOf(ele);
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum+=Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int newEle = sum(nums[i]);
            min = Math.min(min,newEle);
        }
        return min;
        
        
    }
}