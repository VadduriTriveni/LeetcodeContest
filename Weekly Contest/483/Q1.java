class Solution {
    public String largestEvenNumber(String s) {
        int n = s.length();

        // Step 1: Find the index of the rightmost '2'
        int lastEvenIndex = -1; // Initialize to -1 (no even number found yet)
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '2') {
                lastEvenIndex = i;
                break; // Stop at the rightmost '2'
            }
        }

        // Step 2: Check if there is no '2'
        if (lastEvenIndex == -1) {
            return ""; // No even number possible
        }

        // Step 3: Take all characters up to and including the rightmost '2'
        String result = s.substring(0, lastEvenIndex + 1);

        // Step 4: Return the result
        return result;
    }
}

