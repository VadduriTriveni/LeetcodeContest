class Solution {
    public int minMaxDifference(int[] nums, int k) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        int minSum = 0;
        int maxSum = 0;
        int n = nums.length;

        // Step 2: Sum k smallest elements
        for (int i = 0; i < k; i++) {
            minSum += nums[i];
        }

        // Step 3: Sum k largest elements
        for (int i = n - k; i < n; i++) {
            maxSum += nums[i];
        }

        // Step 4: Return absolute difference
        return Math.abs(maxSum - minSum);
    }
}
