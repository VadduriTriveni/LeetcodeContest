class Solution {

    public int minimumCost(String s, int[] cost) {

        // Step 1: Total cost of deleting all characters
        long totalCost = 0;

        // Step 2: Array to store total cost of each character ('a' to 'z')
        long[] charCost = new long[26];

        // Step 3: Traverse the string
        for (int i = 0; i < s.length(); i++) {

            // Add current deletion cost to total cost
            totalCost += cost[i];

            // Add cost to corresponding character bucket
            charCost[s.charAt(i) - 'a'] += cost[i];
        }

        // Step 4: Initialize answer with a very large value
        long minDeletionCost = Long.MAX_VALUE;

        // Step 5: Try keeping each character
        for (int i = 0; i < 26; i++) {

            // Skip characters not present in string
            if (charCost[i] == 0) continue;

            // Cost to delete everything except this character
            long deletionCost = totalCost - charCost[i];

            // Update minimum
            minDeletionCost = Math.min(minDeletionCost, deletionCost);
        }

        // Step 6: Return result as int
        return (int) minDeletionCost;
    }
}
