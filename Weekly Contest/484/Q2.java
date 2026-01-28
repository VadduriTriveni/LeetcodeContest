import java.util.*;

class Solution {
    public int numberOfCenteredSubarrays(int[] nums) {

        int n = nums.length;
        int count = 0;

        // Step 1: Fix starting index of subarray
        for (int i = 0; i < n; i++) {

            int sum = 0;
            Set<Integer> set = new HashSet<>();

            // Step 2: Extend subarray to the right
            for (int j = i; j < n; j++) {

                // Add current element to sum
                sum += nums[j];

                // Store element in set
                set.add(nums[j]);

                // Step 3: Check centered condition
                if (set.contains(sum)) {
                    count++;
                }
            }
        }

        return count;
    }
}
