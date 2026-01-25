class Solution {
    public int countResiduePrefixes(String s) {
        int n = s.length();
        int residueCount = 0; // Step 1: Initialize counter

        Set<Character> distinctChars = new HashSet<>(); // Step 1: To track distinct characters in prefix

        // Step 2: Iterate through the string to consider each prefix
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Step 2.1: Add current character to the set of distinct characters
            distinctChars.add(c);

            // Step 2.2: Compute length of prefix modulo 3
            int prefixLengthMod = (i + 1) % 3;

            // Step 2.3: Count distinct characters in prefix
            int distinctCount = distinctChars.size();

            // Step 2.4: Check residue condition
            if (distinctCount == prefixLengthMod) {
                residueCount++; // Step 2.5: Increment counter if residue condition is satisfied
            }
        }

        // Step 3: Return the total count of residue prefixes
        return residueCount;
    }
}

