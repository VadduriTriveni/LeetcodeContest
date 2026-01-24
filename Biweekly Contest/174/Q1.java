class Solution {
    public int[] bestReachableTower(int[][] towers, int[] center, int radius) {

        // Step 1: Initialize result with [-1, -1] in case no tower is reachable
        int[] bestTower = {-1, -1};

        // Step 2: Track the maximum quality factor among reachable towers
        int maxQuality = -1;

        // Step 3: Extract center coordinates
        int cx = center[0], cy = center[1];

        // Step 4: Iterate through each tower
        for (int[] tower : towers) {
            int x = tower[0]; // tower x-coordinate
            int y = tower[1]; // tower y-coordinate
            int q = tower[2]; // tower quality

            // Step 5: Compute Manhattan distance to the center
            int manhattan = Math.abs(x - cx) + Math.abs(y - cy);

            // Step 6: Skip tower if it is out of reach
            if (manhattan > radius) continue;

            // Step 7: Update the best tower if quality is higher
            if (q > maxQuality) {
                maxQuality = q;
                bestTower[0] = x;
                bestTower[1] = y;
            } 
            // Step 8: If quality is the same, choose lexicographically smaller tower
            else if (q == maxQuality) {
                if (x < bestTower[0] || (x == bestTower[0] && y < bestTower[1])) {
                    bestTower[0] = x;
                    bestTower[1] = y;
                }
            }
        }

        // Step 9: Return the best reachable tower coordinates
        return bestTower;
    }
}
