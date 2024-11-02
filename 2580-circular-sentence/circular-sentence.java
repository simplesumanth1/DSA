class Solution {
    public boolean isCircularSentence(String sentence) {
        String[]nums = sentence.split(" ");
        int n = nums.length;
        if(n==1){
            char first = nums[0].charAt(0);
            char last = nums[0].charAt(nums[0].length()-1);
            if(first != last)return false;
            return true;
        }
        char firstChar = nums[0].charAt(0);
        for(int i =1;i<n;i++){
            char prevWordLast = nums[i-1].charAt(nums[i-1].length()-1);
            char curr = nums[i].charAt(0);
            if(prevWordLast != curr)return false;
        }
        char lastCurr = nums[nums.length-1].charAt(nums[nums.length-1].length()-1);
        if(firstChar != lastCurr)return false;
        return true;
        
    }
}