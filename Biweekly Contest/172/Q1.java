class Solution {
    public int minOperations(int[] nums) {

        int n = nums.length;

        // Step 1: Count frequency of each element
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Count how many elements are duplicated
        int duplicates = 0;
        for (int count : freq.values()) {
            if (count > 1) {
                duplicates++;
            }
        }

        // If already all elements are distinct
        if (duplicates == 0) {
            return 0;
        }

        // Step 3: Simulate removals
        int operations = 0;
        int index = 0;

        while (index < n && duplicates > 0) {
            operations++;

            // Remove up to 3 elements
            for (int i = 0; i < 3 && index < n; i++) {
                int val = nums[index];
                int count = freq.get(val);

                // If frequency goes from 2 -> 1, duplicate resolved
                if (count == 2) {
                    duplicates--;
                }

                freq.put(val, count - 1);
                index++;
            }
        }

        return operations;
    }
}

