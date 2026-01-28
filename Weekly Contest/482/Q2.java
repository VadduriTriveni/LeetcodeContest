class Solution {

    public long minCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        // Step 1: If no items are needed
        if (need1 == 0 && need2 == 0) {
            return 0;
        }

        long totalCost = 0;

        // Step 2: Find how many units can be satisfied by both types
        int common = Math.min(need1, need2);

        // Step 3: Decide whether type3 is cheaper than buying type1 + type2
        if (costBoth < cost1 + cost2) {

            // Buy 'common' number of type3 items
            totalCost += (long) common * costBoth;

            // Reduce remaining requirements
            need1 -= common;
            need2 -= common;
        }

        // Step 4: Buy remaining type1 items
        totalCost += (long) need1 * cost1;

        // Step 5: Buy remaining type2 items
        totalCost += (long) need2 * cost2;

        // Step 6: Return total minimum cost
        return totalCost;
    }
}
