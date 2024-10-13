class Solution {
    static class Pair implements Comparable<Pair>{
        int ele, freq;
        public Pair(int ele, int freq){
            this.ele = ele;
            this.freq = freq;
        }
        public int compareTo(Pair o){
            if (this.freq != o.freq) {
                return (this.freq - o.freq);  // Sort by frequency (ascending)
            }
            return (this.ele - o.ele);  // Sort by element value (descending)
        }
    }

    public int calculateSum(HashMap<Integer, Integer> map, int x) {
        if (map.size() < x) {
            int sum = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                sum += (entry.getKey() * entry.getValue());
            }
            return sum;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > x) pq.poll();  // Keep only top x elements
        }
        
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            sum += (top.ele * top.freq);
        }
        return sum;
    }

    public int[] findXSum(int[] nums, int k, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int sum = calculateSum(map, x);
        int ind = 0;
        ans[ind] = sum;
        
        for (int i = 1; i <= n - k; i++) {
            // Remove the effect of the previous element (left side of window)
            int prevFreq = map.get(nums[i - 1]);
            if (prevFreq == 1) map.remove(nums[i - 1]);
            else map.put(nums[i - 1], prevFreq - 1);

            // Add the effect of the new element (right side of window)
            map.put(nums[i + k - 1], map.getOrDefault(nums[i + k - 1], 0) + 1);

            // Calculate the new x-sum for the current window
            int xsum = calculateSum(map, x);
            ind++;
            ans[ind] = xsum;  // Place result in answer array
        }
        
        return ans;
    }
}
