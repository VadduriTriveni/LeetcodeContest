class Solution {
    public long maxScore(int[] nums) {
        int n = nums.length;

        // Step 1: Find the minimum element in the suffix starting from index 1
        long suffixMin = nums[1];
        for (int i = 2; i < n; i++) {
            suffixMin = Math.min(suffixMin, nums[i]);
        }

        // Step 2: Initialize prefix sum and maximum score
        long prefixSum = nums[0];
        long maxScore = prefixSum - suffixMin;

        // Step 3: Try all valid split positions
        for (int i = 1; i < n - 1; i++) {

            // Update prefix sum
            prefixSum += nums[i];

            // Update suffix minimum (elements to the right of i)
            suffixMin = Math.min(suffixMin, nums[i + 1]);

            // Calculate score for current split
            long score = prefixSum - suffixMin;

            // Update maximum score
            maxScore = Math.max(maxScore, score);
        }

        // Step 4: Return the maximum score
        return maxScore;
    }
}

