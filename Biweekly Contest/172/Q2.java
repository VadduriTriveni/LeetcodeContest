class Solution {

    public int maxSumDivThree(int[] nums) {

        // Step 1: Create three lists to group numbers by remainder when divided by 3
        // r0 -> remainder 0
        // r1 -> remainder 1
        // r2 -> remainder 2
        List<Integer> r0 = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        // Step 2: Traverse the array and place numbers into respective groups
        for (int n : nums) {
            if (n % 3 == 0) {
                r0.add(n);
            } else if (n % 3 == 1) {
                r1.add(n);
            } else {
                r2.add(n);
            }
        }

        // Step 3: Sort each group in descending order
        // This helps us pick the largest numbers first for maximum sum
        Collections.sort(r0, Collections.reverseOrder());
        Collections.sort(r1, Collections.reverseOrder());
        Collections.sort(r2, Collections.reverseOrder());

        // Step 4: Initialize answer to store the maximum valid sum
        int ans = 0;

        // Step 5: Check all valid remainder combinations

        // Case 1: (0, 0, 0)
        if (r0.size() >= 3) {
            ans = Math.max(ans, r0.get(0) + r0.get(1) + r0.get(2));
        }

        // Case 2: (1, 1, 1)
        if (r1.size() >= 3) {
            ans = Math.max(ans, r1.get(0) + r1.get(1) + r1.get(2));
        }

        // Case 3: (2, 2, 2)
        if (r2.size() >= 3) {
            ans = Math.max(ans, r2.get(0) + r2.get(1) + r2.get(2));
        }

        // Case 4: (0, 1, 2)
        if (!r0.isEmpty() && !r1.isEmpty() && !r2.isEmpty()) {
            ans = Math.max(ans, r0.get(0) + r1.get(0) + r2.get(0));
        }

        // Step 6: Return the maximum sum divisible by 3
        // If no valid triplet exists, ans remains 0
        return ans;
    }
}
