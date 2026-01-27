class Solution {

    public int minSubarrayLength(int[] nums, int k) {

        // Step 1: Sliding window pointers
        int left = 0;

        // Step 2: Store frequency of elements in current window
        Map<Integer, Integer> freq = new HashMap<>();

        // Step 3: Track sum of DISTINCT elements in the window
        long distinctSum = 0;

        // Step 4: Initialize answer with large value
        int minLen = Integer.MAX_VALUE;

        // Step 5: Expand window using right pointer
        for (int right = 0; right < nums.length; right++) {

            int val = nums[right];

            // Step 6: Add current element to the window
            // If it appears for the first time, add to distinct sum
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            if (freq.get(val) == 1) {
                distinctSum += val;
            }

            // Step 7: Try shrinking the window while condition is satisfied
            while (distinctSum >= k) {

                // Update minimum length
                minLen = Math.min(minLen, right - left + 1);

                // Remove element at left pointer
                int leftVal = nums[left];
                freq.put(leftVal, freq.get(leftVal) - 1);

                // If element count becomes zero, remove from distinct sum
                if (freq.get(leftVal) == 0) {
                    distinctSum -= leftVal;
                }

                // Move left pointer
                left++;
            }
        }

        // Step 8: If no valid subarray found, return -1
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
