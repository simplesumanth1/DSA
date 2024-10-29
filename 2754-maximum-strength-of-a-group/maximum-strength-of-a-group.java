import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    
    public long maxStrength(int[] nums) {
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        int[]temp = {0,-1};
        if(Arrays.equals(nums,temp))return 0;
        
        for (int ele : nums) {
            if (ele < 0) negatives.add(ele);
            else if (ele > 0) positives.add(ele);
        }
        
       
        if (nums.length == 1) {
            return nums[0];
        }

       
        if (positives.isEmpty() && negatives.size() == 1) {
            return 0;
        }
        
        long product = 1;

        for (int ele : positives) {
            product *= (long) ele;
        }

        Collections.sort(negatives, (a, b) -> Math.abs(b) - Math.abs(a));
        
        int n = negatives.size();
        if (n % 2 == 1) n = n - 1;
        
        for (int i = 0; i < n; i++) {
            product *= (long) negatives.get(i);
        }
        if(positives.size()==0 && negatives.size()==0)return 0;
        return product;
    }
}
