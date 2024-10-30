class Solution {
    public int longestMountain(int[] arr) {

        int max=0;
        int n=  arr.length;
        if(n<3)return 0;
        for(int i=1;i<n-1;i++){
            if(arr[i]> arr[i-1] && arr[i]>arr[i+1]){
                int left = i;
                int right = i;
                while(left>0 && arr[left-1]<arr[left])left--;
                while(right<n-1 && arr[right]>arr[right+1])right++;
                max = Math.max(max,right-left+1);
            }
        }
        return max;
        
    }
}