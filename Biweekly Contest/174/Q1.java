class Solution {
    public int[] bestReachableTower(int[][] towers, int[] center, int radius) {

        int[] bestTower = {-1, -1};
        int maxQuality = -1;
        int cx = center[0];
        int cy = center[1];

        for (int[] tower : towers) {
            int x = tower[0];
            int y = tower[1];
            int q = tower[2];

            int manhattan = Math.abs(x - cx) + Math.abs(y - cy);

            if (manhattan > radius) {
                continue; // tower not reachable
            }

            if (q > maxQuality) {
                maxQuality = q;
                bestTower[0] = x;
                bestTower[1] = y;
            } else if (q == maxQuality) {
                // tie → choose lexicographically smaller
                if (x < bestTower[0] || (x == bestTower[0] && y < bestTower[1])) {
                    bestTower[0] = x;
                    bestTower[1] = y;
                }
            }
        }

        return bestTower;
    }
}

