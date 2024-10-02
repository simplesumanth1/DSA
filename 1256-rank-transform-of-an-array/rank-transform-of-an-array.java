class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0) return new int[]{};
        int[]nums = new int[arr.length];
        for(int i=0;i<arr.length;i++)nums[i]=arr[i];
        Arrays.sort(arr);
        HashMap<Integer,Integer>map = new HashMap<>();
        int rank=1;
        map.put(arr[0],rank);
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1])map.put(arr[i],++rank);
            else map.put(arr[i],rank);

        }
        System.out.println(map);
        int[]res = new int[arr.length];
        for(int n:nums)System.out.println(n);
        for(int i=0;i<nums.length;i++){
            res[i]=map.get(nums[i]);
        }
        return res;

        
    }
}