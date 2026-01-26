class Solution {
    public int removePrefix(int[] nums) {

        // Step 1: Get array length
        int n = nums.length;

        // Step 2: Start checking from the second last element
        // (because we compare nums[i] with nums[i + 1])
        int i = n - 2;

        // Step 3: Move backward while the array is strictly increasing
        // Condition: nums[i] < nums[i + 1]
        while (i >= 0 && nums[i] < nums[i + 1]) {
            i--;
        }

        // Step 4:
        // If loop stopped at index i, then suffix from i+1 to end
        // is strictly increasing.
        // So we remove the prefix [0 ... i]
        return i + 1;
    }
}
