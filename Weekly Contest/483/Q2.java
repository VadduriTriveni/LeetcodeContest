class Solution {

    public List<List<String>> wordSquares(String[] words) {

        List<List<String>> result = new ArrayList<>();

        int n = words.length;

        // Step 1: Try all possible combinations of 4 distinct words
        for (int i = 0; i < n; i++) {
            String top = words[i];

            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                String left = words[j];

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    String right = words[k];

                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k) continue;
                        String bottom = words[l];

                        // Step 2: Check the 4 corner constraints
                        if (top.charAt(0) == left.charAt(0) &&
                            top.charAt(3) == right.charAt(0) &&
                            bottom.charAt(0) == left.charAt(3) &&
                            bottom.charAt(3) == right.charAt(3)) {

                            // Step 3: Valid word square found
                            result.add(Arrays.asList(top, left, right, bottom));
                        }
                    }
                }
            }
        }

        // Step 4: Sort lexicographically by (top, left, right, bottom)
        Collections.sort(result, (a, b) -> {
            for (int i = 0; i < 4; i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });

        return result;
    }
}
