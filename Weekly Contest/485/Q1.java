class Solution {
    public int vowelConsonantScore(String s) {

        // Step 1: Initialize counters for vowels and consonants
        int vowels = 0;
        int consonants = 0;

        // Step 1.1: Create a set for quick vowel lookup
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a'); vowelSet.add('e'); vowelSet.add('i'); vowelSet.add('o'); vowelSet.add('u');

        // Step 2: Iterate through each character in the string
        for (char ch : s.toCharArray()) {

            // Step 2.1: Consider only lowercase letters
            if (ch >= 'a' && ch <= 'z') {

                // Step 2.2: Check if character is a vowel
                if (vowelSet.contains(ch)) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
            // Step 2.3: Ignore digits and spaces
        }

        // Step 3: Compute the score
        int score = 0;
        if (consonants > 0) {
            score = vowels / consonants; // integer division automatically floors
        }

        // Step 4: Return the score
        return score;
    }
}

