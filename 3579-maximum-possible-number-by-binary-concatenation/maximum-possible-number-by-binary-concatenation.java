import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void permutations(int ind, int[] nums, List<int[]> ds) {
        if (ind == nums.length) {
            ds.add(nums.clone());
            return;
        }
        for (int i = ind; i < nums.length; i++) {
            swap(i, ind, nums);
            permutations(ind + 1, nums, ds);
            swap(i, ind, nums);
        }
    }

    public int maxGoodNumber(int[] nums) {
        List<int[]> ds = new ArrayList<>();
        permutations(0, nums, ds);
        int max = Integer.MIN_VALUE;
        for (int[] a : ds) {
            StringBuilder sb = new StringBuilder();
            for (int ele : a) {
                String binaryForm = Integer.toBinaryString(ele);
                sb.append(binaryForm);
            }
            BigInteger b = new BigInteger(sb.toString(), 2);
            max = Math.max(max, b.intValue());
        }
        return max;
    }
}
