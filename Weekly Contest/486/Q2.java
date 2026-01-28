class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length;
        
        // List to store non-negative elements
        List<Integer> nonNegValues = new ArrayList<>();
        // List to store the original indices of those non-negative elements
        List<Integer> nonNegIndices = new ArrayList<>();

        // Step 1: Extract non-negative elements and their indices
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                nonNegValues.add(nums[i]);
                nonNegIndices.add(i);
            }
        }

        int L = nonNegValues.size();
        
        // If there are no non-negative elements or only one, no rotation is needed
        if (L <= 1) {
            return nums;
        }

        // Step 2: Handle rotation logic
        // Left rotation by k is equivalent to moving the element at (i + k) % L to position i
        int effectiveK = k % L;
        if (effectiveK == 0) {
            return nums;
        }

        // Create a temporary array to store the rotated sequence to avoid overwriting 
        // values while filling the original array.
        int[] rotated = new int[L];
        for (int i = 0; i < L; i++) {
            rotated[i] = nonNegValues.get((i + effectiveK) % L);
        }

        // Step 3: Place the rotated elements back into the original indices
        for (int i = 0; i < L; i++) {
            int originalIndex = nonNegIndices.get(i);
            nums[originalIndex] = rotated[i];
        }

        return nums;
    }
}
