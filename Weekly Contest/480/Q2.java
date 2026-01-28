class Solution {

    public String reverseWords(String s) {

        // Step 1: Split the input string into words
        String[] words = s.split(" ");

        // Step 2: Count vowels in the first word
        int firstVowelCount = countVowels(words[0]);

        // Step 3: Traverse remaining words
        for (int i = 1; i < words.length; i++) {

            // Step 4: Count vowels in current word
            int currentVowelCount = countVowels(words[i]);

            // Step 5: If vowel count matches first word,
            // reverse the current word
            if (currentVowelCount == firstVowelCount) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }

        // Step 6: Join words back with spaces and return result
        return String.join(" ", words);
    }

    // Helper method to count vowels in a word
    private int countVowels(String word) {

        int count = 0;

        // Step A: Traverse each character in the word
        for (char c : word.toCharArray()) {

            // Step B: Check if character is a vowel
            if (c == 'a' || c == 'e' || c == 'i' ||
                c == 'o' || c == 'u') {
                count++;
            }
        }

        return count;
    }
}
