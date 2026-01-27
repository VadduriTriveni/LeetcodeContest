class Solution {

    public int minimumOperations(int[] nums, int[] target) {

        int n = nums.length;

        // Step 1: Result counter
        int operations = 0;

        // Step 2: Traverse array index by index
        int i = 0;

        while (i < n) {

            // Step 3: If current value already equals target,
            // no operation needed here, move forward
            if (nums[i] == target[i]) {
                i++;
                continue;
            }

            // Step 4: We found a mismatch → start of a segment
            int x = nums[i];

            // Step 5: Move j to find the maximal contiguous segment
            // where nums[j] == x
            int j = i;
            while (j < n && nums[j] == x) {
                j++;
            }

            // Step 6: Check if this whole segment already matches target
            boolean needOperation = false;
            for (int k = i; k < j; k++) {
                if (nums[k] != target[k]) {
                    needOperation = true;
                    break;
                }
            }

            // Step 7: If at least one index differs from target,
            // we must perform one operation for this segment
            if (needOperation) {
                operations++;
            }

            // Step 8: Move to next segment
            i = j;
        }

        // Step 9: Return total minimum operations
        return operations;
    }
}
