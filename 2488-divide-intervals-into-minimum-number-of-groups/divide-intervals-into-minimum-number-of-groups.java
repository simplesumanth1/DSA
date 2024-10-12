class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        // System.out.println("Intervals");
        // for(int[]nums:intervals)
        // for(int ele:nums)System.out.print(ele+ " ");
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            // System.out.println(pq);
            if(!pq.isEmpty() && pq.peek()<start)pq.poll();
            pq.offer(end);
        }
        return pq.size();
        
    }
}
// [[441459,446342],[801308,840640],[871890,963447],[228525,336985],[807945,946787],[479815,507766],[693292,944029],[751962,821744]]